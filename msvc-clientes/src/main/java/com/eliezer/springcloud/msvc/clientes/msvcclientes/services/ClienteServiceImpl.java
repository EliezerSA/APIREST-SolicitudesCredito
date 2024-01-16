package com.eliezer.springcloud.msvc.clientes.msvcclientes.services;

import com.eliezer.springcloud.msvc.clientes.msvcclientes.models.entity.Cliente;
import com.eliezer.springcloud.msvc.clientes.msvcclientes.repositories.ClienteRepositorie;
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
public class ClienteServiceImpl implements ClienteService{

    //Inyeecion de dependencias
    @Autowired
    private ClienteRepositorie repositorie;
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listar() {

        return (List<Cliente>) repositorie.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cliente> porId(Long id) {
        return repositorie.findById(id);
    }

    @Override
    @Transactional
    public Cliente guardar(Cliente cliente) {
        return repositorie.save(cliente);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repositorie.deleteById(id);

    }

    //Implementar validacionnpor apellidoPaterno
    @Override
    public Optional<Cliente> porApellidoPaterno(String apellidoPaterno) {
        return repositorie.findByApellidoPaterno(apellidoPaterno);
    }
}
