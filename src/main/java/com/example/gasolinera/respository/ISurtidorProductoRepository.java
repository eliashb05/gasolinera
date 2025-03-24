package com.example.gasolinera.respository;

import com.example.gasolinera.model.SurtidorProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISurtidorProductoRepository extends JpaRepository<SurtidorProducto, Long> {

}
