package com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.services;

import com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.entity.Solicitud;
import com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Autor: Eliezer Santiago
 * Fecha: 15/01/2024
 * Servicio de implementacion de metodos
 * */
@Service
public class SolicitudServiceImpl implements SolicitudService{

    //Inyeccion de dependencias
    @Autowired
    private SolicitudRepository repositorie;

    @Override
    @Transactional(readOnly = true)
    public List<Solicitud> listar() {
        return (List<Solicitud>) repositorie.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Solicitud> porId(Long id) {
        return repositorie.findById(id);
    }

    @Override
    @Transactional
    public Solicitud guardar(Solicitud solicitud) {
        return repositorie.save(solicitud);
    }

    @Override
    public void eliminar(Long id) {

        repositorie.deleteById(id);
    }
}
