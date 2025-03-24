package com.example.gasolinera.service;

import com.example.gasolinera.model.Producto;
import com.example.gasolinera.model.Surtidor;
import com.example.gasolinera.model.SurtidorProducto;
import com.example.gasolinera.respository.ISurtidorProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurtidorProductoService implements ISurtidorProductoService {

    @Autowired
    private ISurtidorProductoRepository surtidorProductoServ;

    @Override
    public List<SurtidorProducto> getSurtidorProducto() {
        List<SurtidorProducto> listaSurtidorProducto = surtidorProductoServ.findAll();
        return listaSurtidorProducto;
    }

    @Override
    public void saveSurtidorProducto(SurtidorProducto surpro) {
        surtidorProductoServ.save(surpro);
    }

    @Override
    public void  deleteSurtidorProducto(Long id_surtidor_producto) {
        surtidorProductoServ.deleteById(id_surtidor_producto);
    }

    @Override
    public SurtidorProducto findSurtidorProducto(Long id_surtidor_producto) {
        SurtidorProducto surpro = surtidorProductoServ.findById(id_surtidor_producto).orElse(null);
        return surpro;
    }

    @Override
    public void editSurtidorProducto(Long id_original, Long nuevaId_surtidor_producto, Surtidor nuevoId_surtidor, Producto nuevoId_producto) {

        // busco el objeto original
        SurtidorProducto surpro = this.findSurtidorProducto(id_original);

        // proceso de modificación a nivel lógico
        surpro.setId_surtidor_producto(nuevaId_surtidor_producto);
        surpro.setSurtidor(nuevoId_surtidor);
        surpro.setProducto(nuevoId_producto);

        // guardar los cambios
        this.saveSurtidorProducto(surpro);
    }

    @Override
    public void editSurtidorProducto(SurtidorProducto surpro) {
        this.saveSurtidorProducto(surpro);
    }
}
