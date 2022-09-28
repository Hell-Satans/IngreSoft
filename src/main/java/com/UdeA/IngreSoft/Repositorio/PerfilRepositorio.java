package com.UdeA.IngreSoft.Repositorio;

import com.UdeA.IngreSoft.Entidad.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Long> {
    Perfil findByEmail(String email);
}
