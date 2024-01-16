package com.eliezer.springcloud.msvc.clientes.msvcclientes.repositories;

import com.eliezer.springcloud.msvc.clientes.msvcclientes.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Autor: Eliezer Santiago
 * Fecha: 15/01/2024
 *
 * Repositorio CRUD de metodos
 * */
public interface ClienteRepositorie extends CrudRepository<Cliente, Long> {
    Optional<Cliente> findByApellidoPaterno(String apellidoPaterno);
}
