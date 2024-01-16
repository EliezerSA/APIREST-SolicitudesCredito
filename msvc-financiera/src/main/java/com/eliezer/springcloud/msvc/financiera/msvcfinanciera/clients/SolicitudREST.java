package com.eliezer.springcloud.msvc.financiera.msvcfinanciera.clients;

import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.Cliente;
import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.Solicitud;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/***
 * Autor: Eliezer Santiago
 * Fecha:16/01/2024
 *
 * Descripcion: Clase para consumir metodos http del controlador microservicio financiera
 * */
@FeignClient(name = "msvc-solicitud", url="localhost:8002")
public interface SolicitudREST {
    @GetMapping("/{id}")
    Solicitud detalleSol(@PathVariable Long id);

    @PostMapping("/")
    Solicitud crearSol(@RequestBody Solicitud solicitud);

}
