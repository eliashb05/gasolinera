package com.example.gasolinera.respository;

import com.example.gasolinera.model.Surtidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISurtidorRepository extends JpaRepository <Surtidor, Long> {

}
