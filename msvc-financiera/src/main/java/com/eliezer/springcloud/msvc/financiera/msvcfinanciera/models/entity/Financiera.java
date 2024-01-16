package com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.entity;

import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.Cliente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

/**
 * Autor:Eliezer Santiago
 * Fecha: 15/01/2024
 *
 * Clase entity que contiene los atributos de Financiera
 *
 * */
@Entity
@Table(name="financieras")
public class Financiera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String promotor;
    @NotEmpty
    private String empresa;

    //Relacion con la clase financiera_cliente una financiera puede tener muchos clientes
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "financiera_id")//Crear foreign Key de la otra tabla
    private List<FinancieraCliente> financieraClientes;

    //Atributo no mapeado a peristencia de tablas
    @Transient
    private List<Cliente> clientes;

    public Financiera(){
        financieraClientes = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPromotor() {
        return promotor;
    }

    public void setPromotor(String promotor) {
        this.promotor = promotor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    //Getter y Setter de la relacion con la clase financiera y cliente
    public void addFinancieraCliente(FinancieraCliente financieraCliente){
        financieraClientes.add(financieraCliente);
    }

    public void removeFinancieraCliente(FinancieraCliente financieraCliente){
        financieraClientes.remove(financieraCliente);
    }
    public List<FinancieraCliente> getFinancieraClientes() {
        return financieraClientes;
    }

    public void setFinancieraClientes(List<FinancieraCliente> financieraClientes) {
        this.financieraClientes = financieraClientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
