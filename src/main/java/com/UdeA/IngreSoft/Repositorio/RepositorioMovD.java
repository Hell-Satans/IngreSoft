package com.UdeA.IngreSoft.Repositorio;

import com.UdeA.IngreSoft.Entidad.MovDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioMovD extends JpaRepository<MovDinero, String> {
    public List<MovDinero> findByEmpresaId(int id);





}
