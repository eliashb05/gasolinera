package com.example.gasolinera.controller;

import com.example.gasolinera.model.Surtidor;
import com.example.gasolinera.service.ISurtidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SurtidorController {

    @Autowired
    private ISurtidorService surtidorServ;

    @GetMapping("/surtidor/traer")
    public List<Surtidor> getSurtidor() {
        return surtidorServ.getSurtidor();
    }

    @PostMapping( "surtidor/crear")
    public String saveSurtidor(@RequestBody Surtidor sur) {
        surtidorServ.saveSurtidor(sur);
        return "Surtidor creado correctamente";
    }

    @DeleteMapping("/surtidor/borrar/{id_surtidor}")
    public String deleteSurtidor(@PathVariable Long id_surtidor) {
        surtidorServ.deleteSurtidor(id_surtidor);
        return "Surtidor eliminado correctamente";
    }

    @PutMapping("/surtidor/editar/{id_original}")
    public Surtidor editSurtidor(@PathVariable Long id_original,
                                 @RequestParam(required = false, name = "codigo") String nuevoCodigo,
                                 @RequestParam(required = false, name = "fecha_instalacion") LocalDate Nuevafecha_instalacion,
                                 @RequestParam(required = false, name = "activo") Boolean nuevoActivo) {


        surtidorServ.editSurtidor(id_original, nuevoCodigo, Nuevafecha_instalacion, nuevoActivo != null ? nuevoActivo : false);

        Surtidor sur = surtidorServ.findSurtidor(id_original);
        return sur;
    }

    @PutMapping ("/surtidor/editar")
    public Surtidor editSurtidor(@RequestBody Surtidor sur) {
        surtidorServ.editSurtidor(sur);

        return surtidorServ.findSurtidor(sur.getId_surtidor());
    }

}
