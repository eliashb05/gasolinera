package com.example.gasolinera.service;

import com.example.gasolinera.model.Producto;
import com.example.gasolinera.model.Surtidor;
import com.example.gasolinera.model.SurtidorProducto;

import java.util.List;

public interface ISurtidorProductoService {
    //metodo para traer todos los surtidores
    //lectura
    public List<SurtidorProducto> getSurtidorProducto();

    //alta
    public void saveSurtidorProducto(SurtidorProducto surpro);

    //baja
    public void deleteSurtidorProducto(Long id_surtidor_producto);

    //lectura de un solo objeto
    public SurtidorProducto findSurtidorProducto(Long id_surtidor_producto);

    //edicion-modificacion

    public void editSurtidorProducto(Long id_original, Long id_surtidor_producto, Surtidor id_surtidor, Producto id_producto);


    public void editSurtidorProducto(SurtidorProducto surpro);
}
