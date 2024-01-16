package com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.services;

import com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.entity.Solicitud;

import java.util.List;
import java.util.Optional;

/**
 * Autor: Eliezer Santiago
 * Fecha: 15/01/2024
 * Servicio de de Metodos a implementar en IMPL
 */
public interface SolicitudService{

    List<Solicitud> listar();
    Optional<Solicitud> porId(Long id);
    Solicitud guardar(Solicitud solicitud);
    void eliminar(Long id);

}
