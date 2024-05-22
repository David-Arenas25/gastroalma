package com.restaurante.gastro.alma.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PedidoBebidaPk implements Serializable {
    @Column(name="id_bebida")
    private Integer idBebida;

    @Column(name="id_pedido")
    private Integer idPedido;

    public Integer getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Integer idBebida) {
        this.idBebida = idBebida;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }
}
