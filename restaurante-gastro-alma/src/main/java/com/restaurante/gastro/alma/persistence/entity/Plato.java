package com.restaurante.gastro.alma.persistence.entity;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "platos")
public class Plato {
    @Id
    @Column(name = "id_plato")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "platos_seq")
    @SequenceGenerator(name = "platos_seq", sequenceName = "PLATOS_SEQ", allocationSize = 1)
    private Integer idPlato;

    @Column(name= "nombre_plato")
    private String nombrePlato;

    @Column(name="descripcion_plato")
    private String descripcionPlato;

    @Column(name="precio_plato")
    private Double precioPlato;

    @Column(name="id_mesero")
    private Integer idMesero;


    @ManyToOne
    @JoinColumn(name = "id_mesero",insertable = false,updatable = false)
    private Mesero meseros;

    @OneToMany(mappedBy = "plato", cascade = {CascadeType.ALL})
    private List<PedidoPlato> platos;

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getDescripcionPlato() {
        return descripcionPlato;
    }

    public void setDescripcionPlato(String descripcionPlato) {
        this.descripcionPlato = descripcionPlato;
    }

    public Double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(Double precioPlato) {
        this.precioPlato = precioPlato;
    }

    public Integer getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(Integer idMesero) {
        this.idMesero = idMesero;
    }

    public Mesero getMeseros() {
        return meseros;
    }

    public void setMeseros(Mesero meseros) {
        this.meseros = meseros;
    }

    public List<PedidoPlato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<PedidoPlato> platos) {
        this.platos = platos;
    }
}
