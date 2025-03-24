package com.example.gasolinera.service;

import com.example.gasolinera.model.Producto;
import com.example.gasolinera.model.Tanque;
import java.util.List;

public interface ITanqueService {
    //metodo para traer todos los surtidores
    //lectura
    public List<Tanque> getTanque();

    //alta
    public void saveTanque(Tanque tan);

    //baja
    public void deleteTanque(Long id_tanque);

    //lectura de un solo objeto
    public Tanque findTanque(Long id_tanque);

    //edicion-modificacion

    public void editTanque(Long id_original, String nuevoCodigo, Integer nuevoCapacidadMaxima, int nuevoNivelActual, Producto nuevoIdProducto);

    public void editTanque(Tanque tan);
}
