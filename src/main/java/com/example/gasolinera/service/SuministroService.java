package com.example.gasolinera.service;

import com.example.gasolinera.model.Producto;
import com.example.gasolinera.model.Suministro;
import com.example.gasolinera.model.Surtidor;
import com.example.gasolinera.respository.ISuministroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class SuministroService implements ISuministroService {

    @Autowired
    private ISuministroRepository suministroServ;

    @Override
    public List<Suministro> getSuministro() {
        List<Suministro> listaSuministros = suministroServ.findAll();
        return listaSuministros;
    }

    @Override
    public void saveSuministro(Suministro sum) {
        suministroServ.save(sum);
    }

    @Override
    public void  deleteSuministro(Long id_suministro) {
        suministroServ.deleteById(id_suministro);
    }

    @Override
    public Suministro findSuministro(Long id_suministro) {
        Suministro sum = suministroServ.findById(id_suministro).orElse(null);
        return sum;
    }

    @Override
    public void editSuministro(Long id_original, Surtidor nuevaIdSurtidor, Producto nuevaIdProducto, LocalDate nuevaFecha_hora,
                               BigDecimal nuevoVolumen_litros, BigDecimal nuevoImporte_Euros) {

        // busco el objeto original
        Suministro sum = this.findSuministro(id_original);
        // proceso de modificación a nivel lógico
        sum.setSurtidor(nuevaIdSurtidor);
        sum.setProducto(nuevaIdProducto);
        sum.setFecha_hora(nuevaFecha_hora);
        sum.setVolumen_litros(nuevoVolumen_litros);
        sum.setImporte_euros(nuevoImporte_Euros);

        // guardar los cambios
        this.saveSuministro(sum);
    }

    @Override
    public void editSuministro(Suministro sum) {
        this.saveSuministro(sum);
    }
}
