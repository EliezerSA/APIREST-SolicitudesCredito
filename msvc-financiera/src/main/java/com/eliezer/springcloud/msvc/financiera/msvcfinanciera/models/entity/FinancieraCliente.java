package com.eliezer.springcloud.msvc.financiera.msvcfinanciera.models.entity;

import jakarta.persistence.*;

/***
 * Autor:Eliezer Santiago
 * Fecha:16/01/2024
 *
 * Descripcion: Entidad Financiera cliente intermedia para la comunicacion de
 * microservicios Financiera y Cliente
 *
 */
@Entity
@Table(name = "financiera_cliente")
public class FinancieraCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cliente_id",unique = true)
    private Long clienteId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    //Por id,para que se tome por id, modificar metodo equals.

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;

        }
        if(!(obj instanceof FinancieraCliente)){
            return false;
        }
        FinancieraCliente o = (FinancieraCliente) obj;
        return this.clienteId != null && this.clienteId.equals(o.clienteId);

    }
}
