package com.example.gasolinera.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Suministro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_suministro;
    @Column(name = "fecha_hora", nullable = false)
    private LocalDate fecha_hora;
    @Column(name = "volumen_litros", nullable = false, precision = 10, scale = 2)
    private BigDecimal volumen_litros;
    @Column(name = "importe_euros", nullable = false, precision = 10, scale = 2)
    private BigDecimal importe_euros;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_surtidor", nullable = false)
    private Surtidor surtidor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;


    public Suministro() {

    }

    public Suministro(Long id_suministro,Surtidor id_surtidor, Producto id_producto, LocalDate fecha_hora, BigDecimal volumen_litros, BigDecimal importe_euros) {
        this.id_suministro = id_suministro;
        this.surtidor = id_surtidor;
        this.producto = id_producto;
        this.fecha_hora = fecha_hora;
        this.volumen_litros = volumen_litros;
        this.importe_euros = importe_euros;
    }

    public Long getId_suministro() {
        return id_suministro;
    }

    public void setId_suministro(Long id_suministro) {
        this.id_suministro = id_suministro;
    }

    public LocalDate getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDate fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public BigDecimal getVolumen_litros() {
        return volumen_litros;
    }

    public void setVolumen_litros(BigDecimal volumen_litros) {
        this.volumen_litros = volumen_litros;
    }

    public BigDecimal getImporte_euros() {
        return importe_euros;
    }

    public void setImporte_euros(BigDecimal importe_euros) {
        this.importe_euros = importe_euros;
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

