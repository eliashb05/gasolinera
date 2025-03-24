package com.example.gasolinera.service;
import com.example.gasolinera.model.Surtidor;

import java.time.LocalDate;
import java.util.List;

public interface ISurtidorService {
    //metodo para traer todos los surtidores
    //lectura
    public List<Surtidor> getSurtidor();

    //alta
    public void saveSurtidor(Surtidor sur);

    //baja
    public void deleteSurtidor(Long id_surtidor);

    //lectura de un solo objeto
    public Surtidor findSurtidor(Long id_surtidor);

    //edicion-modificacion

    public void editSurtidor(Long id_original, String nuevoCodigo, LocalDate Nuevafecha_instalacion, boolean nuevoActivo);


    public void editSurtidor(Surtidor sur);
}
