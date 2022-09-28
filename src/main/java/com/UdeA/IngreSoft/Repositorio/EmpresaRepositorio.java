package com.UdeA.IngreSoft.Repositorio;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer> {
    @Query(value="SELECT * FROM empresa where id= ?1", nativeQuery=true)
    public Empresa findByEmpleado(Empleado empleado);
}
