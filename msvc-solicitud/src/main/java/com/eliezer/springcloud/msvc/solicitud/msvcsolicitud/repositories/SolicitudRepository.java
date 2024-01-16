package com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.repositories;

import com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.entity.Solicitud;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SolicitudRepository extends CrudRepository<Solicitud, Long> {

}
