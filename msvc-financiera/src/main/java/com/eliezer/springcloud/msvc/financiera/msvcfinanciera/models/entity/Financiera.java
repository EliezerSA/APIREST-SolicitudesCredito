package com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.entity;

import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.Cliente;
import com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.Solicitud;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "solicitud_id")//Crear foreign key de la otra tabla
    private List<FinancieraSolicitud> financieraSolicitudes;

    //Relacion con la clase financiera_cliente una financiera puede tener muchos clientes
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "financiera_id")//Crear foreign Key de la otra tabla
    private List<FinancieraCliente> financieraClientes;

    //Atributo no mapeado a peristencia de tablas
    @Transient
    private List<Cliente> clientes;
    @Transient
    private List<Solicitud> solicitudes;

    public Financiera(){
        financieraClientes = new ArrayList<>();
        clientes = new ArrayList<>();
        financieraSolicitudes = new ArrayList<>();
        solicitudes = new ArrayList<>();
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

    //Metodos Add y Remove de Solicitudes
    public void addFinancieraSolicitud(FinancieraSolicitud financieraSolicitud){
        financieraSolicitudes.add(financieraSolicitud);
    }

    public void removeFinancieraSolicitud(FinancieraSolicitud financieraSolicitud){
        financieraSolicitudes.remove(financieraSolicitud);
    }

    //Getter y Setter de la relacion con la clase financiera y cliente
    public List<FinancieraSolicitud> getFinancieraSolicitudes() {
        return financieraSolicitudes;
    }

    public void setFinancieraSolicitudes(List<FinancieraSolicitud> financieraSolicitudes) {
        this.financieraSolicitudes = financieraSolicitudes;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
}
