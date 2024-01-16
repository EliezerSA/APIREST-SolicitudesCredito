package com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.repositories;

import com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.entity.Solicitud;
import org.springframework.data.repository.CrudRepository;

public interface SolicitudRepository extends CrudRepository<Solicitud, Long>
{

}
