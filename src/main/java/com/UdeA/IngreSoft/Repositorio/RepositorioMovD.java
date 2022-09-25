package com.UdeA.IngreSoft.Repositorio;

import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Entidad.MovDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioMovD extends JpaRepository<MovDinero, Integer> {
     List<MovDinero> findByEmpresaId(int id);
    List<MovDinero> findByEmpresa(Empresa empresa);
}
