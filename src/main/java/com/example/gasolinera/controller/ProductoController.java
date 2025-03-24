package com.example.gasolinera.controller;

import com.example.gasolinera.model.Producto;
import com.example.gasolinera.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService productoServ;

    @GetMapping("/producto/traer")
    public List<Producto> getProducto() {
        return productoServ.getProducto();
    }

    @PostMapping( "/producto/crear")
    public String saveProducto(@RequestBody Producto pro) {
        productoServ.saveProducto(pro);
        return "Producto creado correctamente";
    }

    @DeleteMapping("/producto/borrar/{id_producto}")
    public String deleteProducto(@PathVariable Long id_producto) {
        productoServ.deleteProducto(id_producto);
        return "Producto eliminado correctamente";
    }

    @PutMapping("/producto/editar/{id_original}")
    public Producto editProducto(@PathVariable Long id_original,
                                 @RequestParam(required = false, name = "nombre") String nuevoNombre,
                                 @RequestParam(required = false, name = "descripcion") String nuevaDescripcion,
                                 @RequestParam(required = false, name = "tipo") String nuevoTipo) {


        productoServ.editProducto(id_original, nuevoNombre, nuevaDescripcion, nuevoTipo);

        Producto pro = productoServ.findProducto(id_original);
        return pro;
    }

    @PutMapping ("/producto/editar")
    public Producto editProducto(@RequestBody Producto pro) {
        productoServ.editProducto(pro);

        return productoServ.findProducto(pro.getId_producto());
    }
}
