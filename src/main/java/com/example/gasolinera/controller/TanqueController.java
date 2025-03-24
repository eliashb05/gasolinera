package com.example.gasolinera.controller;

import com.example.gasolinera.model.Producto;
import com.example.gasolinera.model.Tanque;
import com.example.gasolinera.service.ITanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TanqueController {

    @Autowired
    private ITanqueService tanqueServ;

    @GetMapping("/tanque/traer")
    public List<Tanque> getTanque() {
        return tanqueServ.getTanque();
    }

    @PostMapping( "/tanque/crear")
    public String saveTanque(@RequestBody Tanque tan) {
        tanqueServ.saveTanque(tan);
        return "Tanque creado correctamente";
    }

    @DeleteMapping("/tanque/borrar/{id_tanque}")
    public String deleteTanque(@PathVariable Long id_tanque) {
        tanqueServ.deleteTanque(id_tanque);
        return "Tanque eliminado correctamente";
    }

    @PutMapping("/tanque/editar/{id_original}")
    public Tanque editTanque(@PathVariable Long id_original,
                                 @RequestParam(required = false, name = "codigo") String nuevoCodigo,
                                 @RequestParam(required = false, name = "capacidad_maxima") Integer nuevoCapacidadMaxima,
                                 @RequestParam(required = false, name = "nivel_actual") int nuevoNivelActual,
                                 @RequestParam(required = false, name = "id_producto") Producto nuevoIdProducto) {


        tanqueServ.editTanque(id_original, nuevoCodigo, nuevoCapacidadMaxima, nuevoNivelActual, nuevoIdProducto);

        Tanque tan = tanqueServ.findTanque(id_original);
        return tan;
    }

    @PutMapping ("/tanque/editar")
    public Tanque editTanque(@RequestBody Tanque tan) {
        tanqueServ.editTanque(tan);

        return tanqueServ.findTanque(tan.getId_tanque());
    }
}
