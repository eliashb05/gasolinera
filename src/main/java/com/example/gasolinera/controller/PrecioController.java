package com.example.gasolinera.controller;

import com.example.gasolinera.model.Precio;
import com.example.gasolinera.model.Producto;
import com.example.gasolinera.service.IPrecioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class PrecioController {

    @Autowired
    private IPrecioService precioServ;

    @GetMapping("/precio/traer")
    public List<Precio> getPrecio() {
        return precioServ.getPrecio();
    }

    @PostMapping( "/precio/crear")
    public String savePrecio(@RequestBody Precio pre) {
        precioServ.savePrecio(pre);
        return "Precio creado correctamente";
    }

    @DeleteMapping("/precio/borrar/{id_precio}")
    public String deletePrecio(@PathVariable Long id_precio) {
        precioServ.deletePrecio(id_precio);
        return "Precio eliminado correctamente";
    }

    @PutMapping("/precio/editar/{id_original}")
    public Precio editPrecio(@PathVariable Long id_original,
                                 @RequestParam(required = false, name = "id_producto") Producto id_producto,
                                 @RequestParam(required = false, name = "fecha_inicio") LocalDate nuevaFechaInicio,
                                 @RequestParam(required = false, name = "fecha_fin") LocalDate nuevaFechaFin,
                                 @RequestParam(required = false, name = "precio_por_litro") BigDecimal nuevoPrecioLitro) {


        precioServ.editPrecio(id_original, id_producto, nuevaFechaInicio, nuevaFechaFin, nuevoPrecioLitro);

        Precio pre = precioServ.findPrecio(id_original);
        return pre;
    }

    @PutMapping ("/precio/editar")
    public Precio editPrecio(@RequestBody Precio pre) {
        precioServ.editPrecio(pre);

        return precioServ.findPrecio(pre.getId_precio());
    }

}
