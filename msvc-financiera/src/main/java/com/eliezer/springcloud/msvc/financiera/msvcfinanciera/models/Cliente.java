package com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
/**
 * Autor: Eliezer Santiago
 * Fecha: 16/01/2024
 *
 * Descripcion: Clase qye representa el objeto JSON a obtener en la comunicacion API Rest con
 * nuestros clientes y financiera
 * */
public class Cliente {
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
}
