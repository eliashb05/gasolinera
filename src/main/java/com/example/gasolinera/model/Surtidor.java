package com.example.gasolinera.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.OneToMany;

@Entity
public class Surtidor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_surtidor;
    @Column(nullable = false, unique = true)
    private String codigo;
    @Column(name = "fecha_instalacion")
    private LocalDate fecha_instalacion;
    private boolean activo;

    @OneToMany(mappedBy = "surtidor", cascade = CascadeType.ALL)
    private List<SurtidorProducto> surtidorProductos = new ArrayList<>();

    @OneToMany(mappedBy = "surtidor", cascade = CascadeType.ALL)
    private List<Suministro> suministros = new ArrayList<>();

    public Surtidor() {

    }

    public Surtidor(Long id_surtidor,String codigo, LocalDate fecha_instalacion, boolean activo) {
        this.id_surtidor = id_surtidor;
        this.codigo = codigo;
        this.fecha_instalacion = fecha_instalacion;
        this.activo = activo;
    }

    public Long getId_surtidor() {
        return id_surtidor;
    }

    public void setId_surtidor(Long id_surtidor) {
        this.id_surtidor = id_surtidor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha_instalacion() {
        return fecha_instalacion;
    }

    public void setFecha_instalacion(LocalDate fecha_instalacion) {
        this.fecha_instalacion = fecha_instalacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<SurtidorProducto> getSurtidorProductos() {
        return surtidorProductos;
    }

    public void setSurtidorProductos(List<SurtidorProducto> surtidorProductos) {
        this.surtidorProductos = surtidorProductos;
    }

    public List<Suministro> getSuministros() {
        return suministros;
    }

    public void setSuministros(List<Suministro> suministros) {
        this.suministros = suministros;
    }
}
