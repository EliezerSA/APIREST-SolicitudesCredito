package com.eliezer.springcloud.msvc.financiera.msvcfinanciera.services;

import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.clients.ClienteREST;
import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.Cliente;
import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.entity.Financiera;
import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.entity.FinancieraCliente;
import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.repositories.FinancieraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Autor:Eliezer Santiago
 * Fecha: 15/01/2024
 *
 * Interface que contiene los metodos que implementados de FinancieraService
 *
 * */
@Service
public class FinancieraServiceImpl implements FinancieraService{

    @Autowired
    private FinancieraRepository repository;

    //Inyectar metodos de la interfaz ClienteREST
    @Autowired
    private ClienteREST client;

    @Override
    @Transactional(readOnly = true)
    public List<Financiera> listar() {
        return (List<Financiera>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Financiera> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Financiera guardar(Financiera financiera) {
        return repository.save(financiera);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {

        repository.deleteById(id);
    }

    //Metodos de la comunicacion financiera con clientes
    @Override
    @Transactional
    public Optional<Cliente> asignarCliente(Cliente cliente, Long financieraId) {
        Optional<Financiera> o = repository.findById(financieraId);
        if(o.isPresent()){
            Cliente clienteMsvc = client.detalle(cliente.getId());
            //Obtener la financieraCliente
            Financiera financiera = o.get();
            FinancieraCliente financieraCliente = new FinancieraCliente();
            financieraCliente.setClienteId(clienteMsvc.getId());

            //Asignar
            financiera.addFinancieraCliente(financieraCliente);
            repository.save(financiera);
            return Optional.of(clienteMsvc);

        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Cliente> crearCliente(Cliente cliente, Long financieraId) {
        Optional<Financiera> o = repository.findById(financieraId);
        if(o.isPresent()){
            Cliente clienteNuevoMsvc = client.crear(cliente);
            //Obtener la financieraCliente
            Financiera financiera = o.get();
            FinancieraCliente financieraCliente = new FinancieraCliente();
            financieraCliente.setClienteId(clienteNuevoMsvc.getId());

            //Asignar
            financiera.addFinancieraCliente(financieraCliente);
            repository.save(financiera);
            return Optional.of(clienteNuevoMsvc);

        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Cliente> eliminarCliente(Cliente cliente, Long financieraId) {
        Optional<Financiera> o = repository.findById(financieraId);
        if(o.isPresent()){
            Cliente clienteMsvc = client.detalle(cliente.getId());
            //Obtener la financieraCliente
            Financiera financiera = o.get();
            FinancieraCliente financieraCliente = new FinancieraCliente();
            financieraCliente.setClienteId(clienteMsvc.getId());

            //Asignar
            financiera.removeFinancieraCliente(financieraCliente);
            repository.save(financiera);
            return Optional.of(clienteMsvc);

        }
        return Optional.empty();
    }
}
