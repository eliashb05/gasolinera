package com.example.gasolinera.service;

import com.example.gasolinera.model.Precio;
import com.example.gasolinera.model.Producto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface IPrecioService {
    //metodo para traer todos los surtidores
    //lectura
    public List<Precio> getPrecio();

    //alta
    public void savePrecio(Precio pre);

    //baja
    public void deletePrecio(Long id_precio);

    //lectura de un solo objeto
    public Precio findPrecio(Long id_precio);

    //edicion-modificacion

    public void editPrecio(Long id_original, Producto nuevoProducto, LocalDate nuevaFechaInicio, LocalDate nuevaFechaFin, BigDecimal nuevoPrecioLitro);


    public void editPrecio(Precio pre);

}
