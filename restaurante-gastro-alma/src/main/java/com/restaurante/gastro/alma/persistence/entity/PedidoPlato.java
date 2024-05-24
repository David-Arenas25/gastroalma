package com.restaurante.gastro.alma.persistence.entity;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedido_plato")
public class PedidoPlato {
    @EmbeddedId
    private PedidoPlatoPk id;
    private String comentario;
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_plato",insertable = false,updatable = false)
    private Plato plato;

    @ManyToOne
    @JoinColumn(name = "id_pedido",insertable = false,updatable = false)
    @MapsId("idPedido")
    private Pedido pedido;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public PedidoPlatoPk getId() {

        return id;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public void setId(PedidoPlatoPk id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
