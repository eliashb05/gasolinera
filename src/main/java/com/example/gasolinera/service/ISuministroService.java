package com.example.gasolinera.service;

import com.example.gasolinera.model.Producto;
import com.example.gasolinera.model.Suministro;
import com.example.gasolinera.model.Surtidor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ISuministroService {
    //metodo para traer todos los surtidores
    //lectura
    public List<Suministro> getSuministro();

    //alta
    public void saveSuministro(Suministro sum);

    //baja
    public void deleteSuministro(Long id_suministro);

    //lectura de un solo objeto
    public Suministro findSuministro(Long id_suministro);

    //edicion-modificacion

    public void editSuministro(Long id_original, Surtidor nuevaIdSurtidor, Producto nuevaIdProducto, LocalDate nuevaFecha_hora, BigDecimal nuevoVolumen_litros, BigDecimal nuevoImporte_Euros);


    public void editSuministro(Suministro sum);
}
