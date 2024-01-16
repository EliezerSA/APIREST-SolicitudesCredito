package com.eliezer.springcloud.msvc.clientes.msvcclientes.services;


import com.eliezer.springcloud.msvc.clientes.msvcclientes.models.entity.Cliente;

import java.util.List;
import java.util.Optional;

/**
 * Autor: Eliezer Santiago
 * Fecha: 15/01/2024
 * Servicio de de Metodos a implementar en IMPL
 */
public interface ClienteService {

    /**
     * Metodos a probar en Api
     * */
    List<Cliente> listar();
    Optional<Cliente> porId(Long id);
    Cliente guardar(Cliente cliente);
    void eliminar(Long id);

    //Metodo por apellidoPaterno
    Optional<Cliente> porApellidoPaterno(String apellidoPaterno);

}
