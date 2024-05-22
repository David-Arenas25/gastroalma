package com.restaurante.gastro.alma.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedidos_seq")
    @SequenceGenerator(name = "pedidos_seq", sequenceName = "PEDIDOS_SEQ", allocationSize = 1)
    private Integer idPedido;

    @Column(name = "fecha_pedido")
    private LocalDateTime fechaPedido;

    @Column(name = "precio_pedido")
    private Double precioPedido;

    @Column(name = "id_mesero")
    private Integer idMesero;

    @ManyToOne
    @JoinColumn(name = "id_mesero",insertable = false,updatable = false)
    private Mesero mesero;

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Double getPrecioPedido() {
        return precioPedido;
    }

    public void setPrecioPedido(Double precioPedido) {
        this.precioPedido = precioPedido;
    }

    public Integer getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(Integer idMesero) {
        this.idMesero = idMesero;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;

    }


}
