package com.example.gasolinera.service;

import com.example.gasolinera.model.Producto;
import com.example.gasolinera.respository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {
    @Autowired
    private IProductoRepository productoServ;

    @Override
    public List<Producto> getProducto() {
        List<Producto> listaProductos = productoServ.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto pro) {
        productoServ.save(pro);
    }

    @Override
    public void  deleteProducto(Long id_producto) {
        productoServ.deleteById(id_producto);
    }

    @Override
    public Producto findProducto(Long id_producto) {
        Producto pro = productoServ.findById(id_producto).orElse(null);
        return pro;
    }

    @Override
    public void editProducto(Long id_original, String nuevoNombre,
                             String nuevaDescripcion, String nuevoTipo) {

        // busco el objeto original
        Producto pro = this.findProducto(id_original);

        // proceso de modificación a nivel lógico
        pro.setNombre(nuevoNombre);
        pro.setDescripcion(nuevaDescripcion);
        pro.setTipo(nuevoTipo);

        // guardar los cambios
        this.saveProducto(pro);
    }

    @Override
    public void editProducto(Producto pro) {
        this.saveProducto(pro);
    }

}
