package com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.entity;

import jakarta.persistence.*;

/***
 * Autor:Eliezer Santiago
 * Fecha:16/01/2024
 *
 * Descripcion: Entidad Financiera cliente intermedia para la comunicacion de
 * microservicios Financiera y Solicitudes
 *
 */
@Entity
@Table(name = "financiera_solicitud")
public class FinancieraSolicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "solicitud_id",unique = true)
    private Long solicitudId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSolicitudId() {
        return solicitudId;
    }

    public void setSolicitudId(Long solicitudId) {
        this.solicitudId = solicitudId;
    }

    //Por id,para que se tome por id, modificar metodo equals.

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;

        }
        if(!(obj instanceof FinancieraSolicitud)){
            return false;
        }
        FinancieraSolicitud o = (FinancieraSolicitud) obj;
        return this.solicitudId != null && this.solicitudId.equals(o.solicitudId);

    }
}
