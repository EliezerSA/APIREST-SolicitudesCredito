package com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.controllers;

import com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.entity.Solicitud;
import com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Autor: Eliezer Santiago
 * Fecha: 14/01/2024
 *
 * Controlador para manejar las peticiones API Rest en cada Endpoint
 * */
@RestController
public class SolicitudController {

    @Autowired
    private SolicitudService service;

    //Mapeo de Listar
    @GetMapping
    public List<Solicitud> listar(){
        return service.listar();
    }
    //Mapeo id
    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Solicitud> solicitudOptional = service.porId(id);
        if (solicitudOptional.isPresent()){
            return ResponseEntity.ok(solicitudOptional.get());
        }
        //Respuesta de status http 404 "No encontrado" y si es "Encontrado" = 200
        return ResponseEntity.notFound().build();
    }

    //Guardar un objeto de tipo cliente
    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)//Status creado 201
    public ResponseEntity<?> crear(@RequestBody Solicitud solicitud){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(solicitud));
    }

    //Actualizar un registro o editarlo
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Solicitud solicitud, @PathVariable Long id){
        Optional<Solicitud> s = service.porId(id);
        if(s.isPresent()){
            Solicitud solicitudDb = s.get();
            solicitudDb.setMonto(solicitud.getMonto());
            solicitudDb.setProducto(solicitud.getProducto());
            solicitudDb.setTipoSolicitudStr(solicitud.getTipoSolicitudStr());
            solicitudDb.setIdTipoSolicitud(solicitud.getIdTipoSolicitud());
            solicitudDb.setTasa(solicitud.getTasa());
            solicitudDb.setPlazo(solicitud.getPlazo());
            solicitudDb.setFrecuencia(solicitud.getFrecuencia());
            solicitudDb.setFechaSolicitud(solicitud.getFechaSolicitud());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(solicitudDb));
        }
        return ResponseEntity.notFound().build();
    }

    //Eliminar registro por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Solicitud> s = service.porId(id);
        if (s.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
