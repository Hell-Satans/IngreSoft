package com.UdeA.IngreSoft.Repositorio;

import com.UdeA.IngreSoft.Entidad.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface empleadoRepositorio extends JpaRepository<Empleado,String> {
}
