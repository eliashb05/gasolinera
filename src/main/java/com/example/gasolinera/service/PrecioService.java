package com.example.gasolinera.service;

import com.example.gasolinera.model.Precio;
import com.example.gasolinera.model.Producto;
import com.example.gasolinera.respository.IPrecioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class PrecioService implements IPrecioService {

    @Autowired
    private IPrecioRepository precioServ;

    @Override
    public List<Precio> getPrecio() {
        List<Precio> listaPrecios = precioServ.findAll();
        return listaPrecios;
    }

    @Override
    public void savePrecio(Precio pre) {
        precioServ.save(pre);
    }

    @Override
    public void deletePrecio(Long id_precio) {
        precioServ.deleteById(id_precio);
    }

    @Override
    public Precio findPrecio(Long id_precio) {
        Precio pre = precioServ.findById(id_precio).orElse(null);
        return pre;
    }

    @Override
    public void editPrecio(Long id_original, Producto nuevoProducto, LocalDate nuevaFechaInicio, LocalDate nuevaFechaFin, BigDecimal nuevoPrecioLitro) {

        // busco el objeto original
        Precio pre = this.findPrecio(id_original);

        // proceso de modificación a nivel lógico
        pre.setProducto(nuevoProducto);
        pre.setFecha_inicio(nuevaFechaInicio);
        pre.setFecha_fin(nuevaFechaFin);
        pre.setPrecio_por_litro(nuevoPrecioLitro);

        // guardar los cambios
        this.savePrecio(pre);
    }

    @Override
    public void editPrecio(Precio pre) {
        this.savePrecio(pre);
    }
}
