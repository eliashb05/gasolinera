package com.example.gasolinera.service;

import com.example.gasolinera.model.Producto;
import com.example.gasolinera.model.Tanque;
import com.example.gasolinera.respository.ITanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TanqueService implements ITanqueService {

    @Autowired
    private ITanqueRepository tanqueServ;

    @Override
    public List<Tanque> getTanque() {
        List<Tanque> listaTanques = tanqueServ.findAll();
        return listaTanques;
    }

    @Override
    public void saveTanque(Tanque tan) {
        tanqueServ.save(tan);
    }

    @Override
    public void  deleteTanque(Long id_tanque) {
        tanqueServ.deleteById(id_tanque);
    }

    @Override
    public Tanque findTanque(Long id_tanque) {
        Tanque tan = tanqueServ.findById(id_tanque).orElse(null);
        return tan;
    }

    @Override
    public void editTanque(Long id_original, String nuevoCodigo, Integer nuevoCapacidadMaxima, int nuevoNivelActual,
                               Producto nuevoIdProducto) {

        // busco el objeto original
        Tanque tan = this.findTanque(id_original);

        // proceso de modificación a nivel lógico
        tan.setCodigo(nuevoCodigo);
        tan.setProducto(nuevoIdProducto);
        tan.setCapacidad_maxima(nuevoCapacidadMaxima);
        tan.setNivel_actual(nuevoNivelActual);

        // guardar los cambios
        this.saveTanque(tan);
    }

    @Override
    public void editTanque(Tanque tan) {
        this.saveTanque(tan);
    }

}
