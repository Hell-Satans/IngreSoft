package com.UdeA.IngreSoft.Repositorio;

import com.UdeA.IngreSoft.Entidad.MovDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface mdRepositorio extends JpaRepository<MovDinero, String> {
    Optional<MovDinero> findById(String Id);


}
