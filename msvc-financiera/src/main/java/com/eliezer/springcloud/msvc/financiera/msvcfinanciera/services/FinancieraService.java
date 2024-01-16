package com.eliezer.springcloud.msvc.financiera.msvcfinanciera.services;

import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.Cliente;
import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.entity.Financiera;

import java.util.List;
import java.util.Optional;

/**
 * Autor:Eliezer Santiago
 * Fecha: 15/01/2024
 *
 * Interface que contiene los metodos a implementar en clase de implementacion
 *
 * */
public interface FinancieraService {
    List<Financiera> listar();
    Optional<Financiera> porId(Long id);
    Financiera guardar(Financiera financiera);
    void eliminar(Long id);

    //Metodo para obtener de otro servicio en este caso cliente
    Optional<Cliente> asignarCliente(Cliente cliente, Long financieraId);
    Optional<Cliente> crearCliente(Cliente cliente, Long financieraId);
    Optional<Cliente> eliminarCliente(Cliente cliente, Long financieraId);

}
