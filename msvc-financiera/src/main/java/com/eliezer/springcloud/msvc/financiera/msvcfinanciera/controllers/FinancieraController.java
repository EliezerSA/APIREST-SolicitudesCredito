package com.eliezer.springcloud.msvc.financiera.msvcfinanciera.controllers;

import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.Cliente;
import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.entity.Financiera;
import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.services.FinancieraService;
import feign.FeignException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Autor: Eliezer Santiago
 * Fecha: 15/01/2024
 *
 * Clase controller que contiene los metodos del API REST de Financiera
 */
@RestController
public class FinancieraController {

    @Autowired
    private FinancieraService service;


    @GetMapping
    public ResponseEntity <List<Financiera>> listar(){
        return  ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Financiera> f = service.porId(id);
        if(f.isPresent()){
            return  ResponseEntity.ok(f.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> crear(@Valid @RequestBody Financiera financiera, BindingResult result){
        if(result.hasErrors()){//Si hay errores en los campos
            return validar(result);
        }
        Financiera financieraDb = service.guardar(financiera);
        return ResponseEntity.status(HttpStatus.CREATED).body(financieraDb);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Financiera financiera, BindingResult result, @PathVariable Long id){
        if(result.hasErrors()){//Si hay errores en los campos
            return validar(result);
        }
        Optional<Financiera> f = service.porId(id);
        if(f.isPresent()){
            Financiera financieraDb = f.get();
            financieraDb.setPromotor(financiera.getPromotor());
            financieraDb.setEmpresa(financiera.getEmpresa());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(financieraDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Financiera> f = service.porId(id);
        if(f.isPresent()){
            service.eliminar(f.get().getId());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Metodos de mapaeo de los nuevos metodos de la relacion cliente financiera
    @PutMapping("/asignar-cliente/{financieraId}")
    public ResponseEntity<?> asignarCliente(@RequestBody Cliente cliente, @PathVariable Long financieraId){
        Optional<Cliente> o;
        try {
            o = service.asignarCliente(cliente, financieraId);
        }catch (FeignException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("mensaje", "No existe el cliente por " +
                            "el id o error en la comunicacion: " + e.getMessage() ));
        }
        if(o.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/crear-cliente/{financieraId}")
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente, @PathVariable Long financieraId){
        Optional<Cliente> o;
        try {
            o = service.crearCliente(cliente, financieraId);
        }catch (FeignException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("mensaje", "No se pudo crear el cliente " +
                            "o error en la comunicacion: " + e.getMessage() ));
        }
        if(o.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/eliminar-cliente/{financieraId}")
    public ResponseEntity<?> eliminarCliente(@RequestBody Cliente cliente, @PathVariable Long financieraId){
        Optional<Cliente> o;
        try {
            o = service.eliminarCliente(cliente, financieraId);
        }catch (FeignException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("mensaje", "No existe el cliente por " +
                            "el id o error en la comunicacion: " + e.getMessage() ));
        }
        if(o.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(o.get());
        }
        return ResponseEntity.notFound().build();
    }


    //Metodo extraido para validar campos
    private ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err ->{
            errores.put(err.getField(),"El campo " + err.getField()+ "" +err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }
}
