package com.example.gasolinera.controller;

import com.example.gasolinera.model.Producto;
import com.example.gasolinera.model.Suministro;
import com.example.gasolinera.model.Surtidor;
import com.example.gasolinera.service.ISuministroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class SuministroController {

    @Autowired
    private ISuministroService suministroServ;

    @GetMapping("/suministro/traer")
    public List<Suministro> getSuministro() {
        return suministroServ.getSuministro();
    }

    @PostMapping( "/suministro/crear")
    public String saveSuministro(@RequestBody Suministro sum) {
        suministroServ.saveSuministro(sum);
        return "Suministro creado correctamente";
    }

    @DeleteMapping("/suministro/borrar/{id_suministro}")
    public String deleteSuministro(@PathVariable Long id_suministro) {
        suministroServ.deleteSuministro(id_suministro);
        return "Suministro eliminado correctamente";
    }

    @PutMapping("/suministro/editar/{id_original}")
    public Suministro editSuministro(@PathVariable Long id_original,
                                     @RequestParam(required = false, name = "id_surtidor") Surtidor id_surtidor,
                                     @RequestParam(required = false, name = "id_producto") Producto id_producto,
                                     @RequestParam(required = false, name = "fecha_hora") LocalDate nuevaFecha_hora,
                                     @RequestParam(required = false, name = "volumen_litros") BigDecimal nuevoVolumen_litros,
                                     @RequestParam(required = false, name = "importe_euros") BigDecimal nuevoImporte_Euros)
            {


                suministroServ.editSuministro(id_original, id_surtidor, id_producto, nuevaFecha_hora,nuevoVolumen_litros, nuevoImporte_Euros);

        Suministro sum = suministroServ.findSuministro(id_original);
        return sum;
    }

    @PutMapping ("/suministro/editar")
    public Suministro editSuministro(@RequestBody Suministro sum) {
        suministroServ.editSuministro(sum);

        return suministroServ.findSuministro(sum.getId_suministro());
    }

}
