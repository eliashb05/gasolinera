package com.example.gasolinera.controller;

import com.example.gasolinera.model.Producto;
import com.example.gasolinera.model.Surtidor;
import com.example.gasolinera.model.SurtidorProducto;
import com.example.gasolinera.service.ISurtidorProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class SurtidorProductoController {

    @Autowired
    private ISurtidorProductoService  SurtidorProductoServ;

    @GetMapping("/surtidor/producto/traer")
    public List<SurtidorProducto> getSurtidorProducto() {
        return SurtidorProductoServ.getSurtidorProducto();
    }

    @PostMapping( "/surtidor/producto/crear")
    public String saveSurtidorProducto(@RequestBody SurtidorProducto surpro) {
        SurtidorProductoServ.saveSurtidorProducto(surpro);
        return "Surtidor-Producto creado correctamente";
    }

    @DeleteMapping("/surtidor/producto/borrar/{id_surtidor}")
    public String deleteSurtidorProducto(@PathVariable Long id_surtidor_producto) {
        SurtidorProductoServ.deleteSurtidorProducto(id_surtidor_producto);
        return "Surtidor-Producto eliminado correctamente";
    }

    @PutMapping("/surtidor/producto/editar/{id_original}")
    public SurtidorProducto editSurtidorProducto(@PathVariable Long id_original,
                                 @RequestParam(required = false, name = "id_surtidor_producto") Long nuevaId_surtidor_producto,
                                 @RequestParam(required = false, name = "id_surtidor") Surtidor nuevoId_surtidor,
                                 @RequestParam(required = false, name = "id_producto") Producto nuevoId_producto) {


        SurtidorProductoServ.editSurtidorProducto(id_original, nuevaId_surtidor_producto, nuevoId_surtidor, nuevoId_producto);

        SurtidorProducto surpro = SurtidorProductoServ.findSurtidorProducto(nuevaId_surtidor_producto);
        return surpro;
    }

    @PutMapping ("/surtidor/producto/editar")
    public SurtidorProducto editSurtidorProducto(@RequestBody SurtidorProducto surpro) {
        SurtidorProductoServ.editSurtidorProducto(surpro);

        return SurtidorProductoServ.findSurtidorProducto(surpro.getId_surtidor_producto());
    }

}
