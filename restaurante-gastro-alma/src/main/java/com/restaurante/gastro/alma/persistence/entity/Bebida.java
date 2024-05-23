package com.restaurante.gastro.alma.persistence.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bebidas")
public class Bebida {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bebidas_seq")
    @SequenceGenerator(name = "bebidas_seq", sequenceName = "BEBIDAS_SEQ1", allocationSize = 1)
    @Column(name = "id_bebida")
    private Integer idBebida;

    @Column(name= "nombre_bebida")
    private String nombreBebida;

    @Column(name="descripcion_bebida")
    private String descripcionBebida;

    @Column(name="precio_bebida")
    private Double precioBebida;

    @Column(name="id_mesero")
    private Integer idMesero;

    @ManyToOne
    @JoinColumn(name = "id_mesero", insertable = false,updatable = false)
    private Mesero meseros;

    @OneToMany(mappedBy = "bebida",cascade = CascadeType.ALL)
    private List<PedidoBebida> bebidas;

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

    public Double getPrecioBebida() {
        return precioBebida;
    }

    public void setPrecioBebida(Double precioBebida) {
        this.precioBebida = precioBebida;
    }

    public String getDescripcionBebida() {
        return descripcionBebida;
    }

    public void setDescripcionBebida(String descripcionBebida) {
        this.descripcionBebida = descripcionBebida;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public Integer getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Integer idBebida) {
        this.idBebida = idBebida;
    }

    public List<PedidoBebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(List<PedidoBebida> bebidas) {
        this.bebidas = bebidas;
    }

}
