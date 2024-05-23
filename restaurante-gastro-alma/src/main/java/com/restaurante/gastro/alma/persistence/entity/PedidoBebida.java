package com.restaurante.gastro.alma.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedido_bebida")
public class PedidoBebida {

    @EmbeddedId
    private PedidoBebidaPk id;
    private String comentario;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_bebida",insertable = false,updatable = false)
    @MapsId("idBebida")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_pedido",insertable = false,updatable = false)
    private Bebida bebida;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Bebida getBebida() {
        return bebida;
    }

    public void setBebida(Bebida bebida) {
        this.bebida = bebida;
    }

    public PedidoBebidaPk getId() {
        return id;
    }

    public void setId(PedidoBebidaPk id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
