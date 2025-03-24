package com.example.gasolinera.model;

import jakarta.persistence.*;

@Entity
public class SurtidorProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_surtidor_producto;


    @ManyToOne
    @JoinColumn(name = "id_surtidor", nullable = false)
    private Surtidor surtidor;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    public SurtidorProducto() {

    }
    public SurtidorProducto(Long id_surtidor_producto,Surtidor id_surtidor, Producto id_producto) {
        this.id_surtidor_producto = id_surtidor_producto;
        this.surtidor = id_surtidor;
        this.producto = id_producto;
    }

    public Long getId_surtidor_producto() {
        return id_surtidor_producto;
    }

    public void setId_surtidor_producto(Long id_surtidor_producto) {
        this.id_surtidor_producto = id_surtidor_producto;
    }

    public Surtidor getSurtidor() {
        return surtidor;
    }

    public void setSurtidor(Surtidor surtidor) {
        this.surtidor = surtidor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
