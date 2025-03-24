package com.example.gasolinera.service;

import com.example.gasolinera.model.Producto;

import java.util.List;

public interface IProductoService {
    //metodo para traer todos los surtidores
    //lectura
    public List<Producto> getProducto();

    //alta
    public void saveProducto(Producto pro);

    //baja
    public void deleteProducto(Long id_producto);

    //lectura de un solo objeto
    public Producto findProducto(Long id_producto);

    //edicion-modificacion

    public void editProducto(Long id_original, String nuevoNombre, String nuevaDescripcion, String nuevoTipo);


    public void editProducto(Producto pro);
}
