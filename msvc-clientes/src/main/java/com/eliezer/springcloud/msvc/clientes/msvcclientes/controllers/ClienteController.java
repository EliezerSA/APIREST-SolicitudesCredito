package com.eliezer.springcloud.msvc.clientes.msvcclientes.controllers;

import com.eliezer.springcloud.msvc.clientes.msvcclientes.models.entity.Cliente;
import com.eliezer.springcloud.msvc.clientes.msvcclientes.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Autor: Eliezer Santiago
 * Fecha: 14/01/2024
 *
 * Controlador para manejar las peticiones API Rest en cada Endpoint
 * */
@RestController
public class ClienteController {

    //Inyeeccion de servicio
    @Autowired
    private ClienteService service;

    //Mapeo de Listar
    @GetMapping
    public List<Cliente> listar(){
        return service.listar();
    }
    //Mapeo id
    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Cliente> clienteOptional = service.porId(id);
        if (clienteOptional.isPresent()){
            return ResponseEntity.ok(clienteOptional.get());
        }
        //Respuesta de status http 404 "No encontrado" y si es "Encontrado" = 200
        return ResponseEntity.notFound().build();
    }

    //Guardar un objeto de tipo cliente
    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)//Status creado 201
    public ResponseEntity<?> crear(@Valid @RequestBody Cliente cliente, BindingResult result){
        //Existe por ejemplo un cliente con ese apellido paterno
        if (!cliente.getApellidoPaterno().isEmpty() && service.porApellidoPaterno(cliente.getApellidoPaterno()).isPresent()){
            return ResponseEntity.badRequest()
                    .body(Collections
                            .singletonMap("mensaje", "Ya existe un cliente con ese apellido paterno"));
        }
        if(result.hasErrors()){//Si hay errores en los campos
            return validar(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(cliente));
    }

    //Actualizar un registro o editarlo
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Cliente cliente,BindingResult result, @PathVariable Long id){

        if(result.hasErrors()){//Si hay errores en los campos
            return validar(result);
        }
        Optional<Cliente> o = service.porId(id);
        if(o.isPresent()){
            Cliente clienteDb = o.get();
            //Existe por ejemplo un cliente con ese apellido paterno
            if (!cliente.getApellidoPaterno().isEmpty() &&
                    !cliente.getApellidoMaterno().equalsIgnoreCase(clienteDb.getApellidoMaterno()) &&
                    service.porApellidoPaterno(cliente.getApellidoPaterno()).isPresent()){
                return ResponseEntity.badRequest()
                        .body(Collections
                                .singletonMap("mensaje", "Ya existe un cliente con ese apellido paterno"));
            }
            clienteDb.setNombre(cliente.getNombre());
            clienteDb.setApellidoPaterno(cliente.getApellidoPaterno());
            clienteDb.setApellidoMaterno(cliente.getApellidoMaterno());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(clienteDb));
        }
        return ResponseEntity.notFound().build();
    }

    //Eliminar registro por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Cliente> o = service.porId(id);
        if (o.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Metodo extraido para validar campos
    private ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err ->{
            errores.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }

}
