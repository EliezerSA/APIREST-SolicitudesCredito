package com.eliezer.springcloud.msvc.solicitud.msvcsolicitud.entity;

import jakarta.persistence.*;

/**
 * Autor: Eliezer Santiago
 * Fecha: 15/01/2024
 *
 * Clase principal de solicitudes para el microservicio de solicitudes
 *
 * */
@Entity
@Table(name = "solicitudes")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int monto;
    private String producto;
    private String tipoSolicitudStr;
    private int idTipoSolicitud;
    private int tasa;
    private int plazo;
    private String frecuencia;
    private String fechaSolicitud;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getTipoSolicitudStr() {
        return tipoSolicitudStr;
    }

    public void setTipoSolicitudStr(String tipoSolicitudStr) {
        this.tipoSolicitudStr = tipoSolicitudStr;
    }

    public int getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(int idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public int getTasa() {
        return tasa;
    }

    public void setTasa(int tasa) {
        this.tasa = tasa;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(String fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }
}
