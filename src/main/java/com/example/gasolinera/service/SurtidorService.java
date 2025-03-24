package com.example.gasolinera.service;

import com.example.gasolinera.model.Surtidor;
import com.example.gasolinera.respository.ISurtidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SurtidorService implements ISurtidorService {

    @Autowired
    private ISurtidorRepository surtidorServ;

    @Override
    public List<Surtidor> getSurtidor() {
        List<Surtidor> listaSurtidores = surtidorServ.findAll();
        return listaSurtidores;
    }

    @Override
    public void saveSurtidor(Surtidor sur) {
        surtidorServ.save(sur);
    }

    @Override
    public void  deleteSurtidor(Long id_surtidor) {
        surtidorServ.deleteById(id_surtidor);
    }

    @Override
    public Surtidor findSurtidor(Long id_surtidor) {
        Surtidor sur = surtidorServ.findById(id_surtidor).orElse(null);
        return sur;
    }

    @Override
    public void editSurtidor(Long id_original, String nuevoCodigo,
                             LocalDate Nuevafecha_instalacion, boolean nuevoActivo) {

        // busco el objeto original
        Surtidor sur = this.findSurtidor(id_original);

        // proceso de modificación a nivel lógico
        sur.setCodigo(nuevoCodigo);
        sur.setFecha_instalacion(Nuevafecha_instalacion);
        sur.setActivo(nuevoActivo);

        // guardar los cambios
        this.saveSurtidor(sur);
    }

    @Override
    public void editSurtidor(Surtidor sur) {
        this.saveSurtidor(sur);
    }
}
