package com.eliezer.springcloud.msvc.financiera.msvcfinanciera.clients;

import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.Cliente;
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
@FeignClient(name = "msvc-clientes", url="localhost:8080")
public interface ClienteREST {
    //Consumir el detalle
    @GetMapping("/{id}")
    Cliente detalle(@PathVariable Long id);

    @PostMapping("/")
    Cliente crear(@RequestBody Cliente cliente);

}
