package com.UdeA.IngreSoft.Repositorio;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Entidad.MovDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioMovD extends JpaRepository<MovDinero, Integer> {
    @Query(value ="select * from mov_dinero where empleado_id= ?1", nativeQuery = true)
    public abstract List<MovDinero> findByEmpleado(Empleado empleado);

    @Query(value="select * from mov_dinero where empleado_id in (select idempleado from empleado where empresa_id= ?1)", nativeQuery = true)
    public abstract List<MovDinero> findByEmpresa(Empresa empresa);

    @Query(value="SELECT SUM(monto) from mov_dinero", nativeQuery = true)
    public abstract Long SumarMontos();

    @Query(value="SELECT SUM(monto) from mov_dinero where empleado_id=?1", nativeQuery = true)
    public abstract Long MontosPorEmpleado(Integer id); //id del empleado

    @Query(value="select sum(monto) from mov_dinero where empleado_id in (select idempleado from empleado where empresa_id= ?1)", nativeQuery = true)
    public abstract Long MontosPorEmpresa(Integer id); //Id de la empresa

    @Query(value="select id from empleado where correo=?1", nativeQuery = true)
    public abstract Integer IdPorCorreo(String correo);
}
