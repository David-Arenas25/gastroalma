package com.restaurante.gastro.alma.persistence.entity;
import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class PedidoPlatoPk implements Serializable {
    @Column(name="id_plato")
    private Integer idPlato;

    @Column(name="id_pedido")
    private Integer idPedido;


    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

}
