package com.restaurante.gastro.alma.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="meseros")
public class Mesero {

    @Id
    @Column(name="id_mesero")
    private Integer idMesero;

    @Column(name="nombre_mesero")
    private String nombreMesero;

    @Column(name="apellido_mesero")
    private String apellidoMesero;

    @OneToMany(mappedBy = "meseros", cascade = {CascadeType.ALL})
    private List<Bebida> bebidas;

    @OneToMany(mappedBy = "meseros", cascade = {CascadeType.ALL})
    private List<Plato> platos;

    @OneToMany(mappedBy = "mesero", cascade = {CascadeType.ALL})
    private List<Pedido> pedidos;


    public String getApellidoMesero() {
        return apellidoMesero;
    }

    public void setApellidoMesero(String apellidoMesero) {
        this.apellidoMesero = apellidoMesero;
    }

    public String getNombreMesero() {
        return nombreMesero;
    }

    public void setNombreMesero(String nombreMesero) {
        this.nombreMesero = nombreMesero;
    }

    public Integer getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(Integer idMesero) {
        this.idMesero = idMesero;
    }

    public List<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Plato> platoes) {
        this.platos = platoes;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }


    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}
