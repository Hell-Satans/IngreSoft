package com.UdeA.IngreSoft.Repositorio;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface empleadoRepositorio extends JpaRepository<Empleado, Integer > {
    @Query(value="SELECT * FROM empleado where empresa_id= ?1", nativeQuery=true)
    public List<Empleado>findByEmpresa(Empresa empresa);
}
