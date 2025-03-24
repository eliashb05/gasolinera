package com.example.gasolinera.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_precio;
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fecha_inicio;
    @Column(name = "fecha_fin")
    private LocalDate fecha_fin;
    @Column(name = "precio_por_litro", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio_por_litro;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;


    public Precio() {

    }

    public Precio(Long id_precio,Producto producto, LocalDate fecha_inicio, LocalDate fecha_fin, BigDecimal precio_por_litro) {
        this.id_precio = id_precio;
        this.producto = producto;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.precio_por_litro = precio_por_litro;
    }

    public Long getId_precio() {
        return id_precio;
    }

    public void setId_precio(Long id_precio) {
        this.id_precio = id_precio;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public BigDecimal getPrecio_por_litro() {
        return precio_por_litro;
    }

    public void setPrecio_por_litro(BigDecimal precio_por_litro) {
        this.precio_por_litro = precio_por_litro;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
