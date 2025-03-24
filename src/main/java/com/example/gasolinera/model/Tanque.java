package com.example.gasolinera.model;

import jakarta.persistence.*;

@Entity
public class Tanque {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_tanque;
    @Column(nullable = true, unique = true)
    private String codigo;
    @Column(name = "capacidad_maxima", nullable = false)
    private Integer capacidad_maxima;
    @Column(name = "nivel_actual", nullable = false)
    private int nivel_actual;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    public Tanque() {

    }

    public Tanque(Long id_tanque, String codigo, Integer capacidad_maxima, int nivel_actual, Producto id_producto) {
        this.id_tanque = id_tanque;
        this.codigo = codigo;
        this.capacidad_maxima = capacidad_maxima;
        this.nivel_actual = nivel_actual;
        this.producto = id_producto;
    }

    public Long getId_tanque() {
        return id_tanque;
    }

    public void setId_tanque(Long id_tanque) {
        this.id_tanque = id_tanque;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCapacidad_maxima() {
        return capacidad_maxima;
    }

    public void setCapacidad_maxima(Integer capacidad_maxima) {
        this.capacidad_maxima = capacidad_maxima;
    }

    public int getNivel_actual() {
        return nivel_actual;
    }

    public void setNivel_actual(int nivel_actual) {
        this.nivel_actual = nivel_actual;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
