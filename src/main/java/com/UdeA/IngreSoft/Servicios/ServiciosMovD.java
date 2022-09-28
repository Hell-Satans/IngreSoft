package com.UdeA.IngreSoft.Servicios;


import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.MovDinero;
import com.UdeA.IngreSoft.Repositorio.EmpresaRepositorio;
import com.UdeA.IngreSoft.Repositorio.RepositorioMovD;
import com.UdeA.IngreSoft.Repositorio.empleadoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class ServiciosMovD {
    private RepositorioMovD MovdRepositorio;
    private EmpresaRepositorio empresaRepo;
    private empleadoRepositorio empleadoRepo;


    public ServiciosMovD(RepositorioMovD movdRepositorio, EmpresaRepositorio empresaRepo, empleadoRepositorio empleadoRepo) {
        MovdRepositorio = movdRepositorio;
        this.empresaRepo = empresaRepo;
        this.empleadoRepo = empleadoRepo;
    }
    public List<MovDinero> listarMovimientos(){
        List<MovDinero> movsList = new ArrayList<>();
        MovdRepositorio.findAll().forEach(movDinero -> movsList.add(movDinero));
        return movsList;
    }

    public Optional<MovDinero> buscarMovimiento(int Id) {
        return MovdRepositorio.findById(Id);
    }
    public MovDinero buscarMov(int id){
        return MovdRepositorio.findById(id).get();
    }

    /*public List<MovDinero> movimientosDineroEmpresa(int id) {
        return  MovdRepositorio.findByEmpresaId(id);
    }*/
    public boolean agregarMov(MovDinero mov){
        MovDinero mto=MovdRepositorio.save(mov);
        if (MovdRepositorio.findById(mto.getId())!=null){
            return true;
        }
        return false;
    }

    /*public boolean agregarMovimiento(int id, int idempleado, MovDinero movimiento) {
        empresaRepo.findById(id).map(empresa -> {
            movimiento.setEmpresa(empresa);
            return empresa;
        });
        empleadoRepo.findById(idempleado).map(empleado -> {
            movimiento.setEmpleado(empleado);
            return MovdRepositorio.save(movimiento);
        }).get();
        return true;
    }*/
    public boolean agregarMovi(int id, MovDinero movimiento){
        empleadoRepo.findById(id).map(empl->{
            movimiento.setEmpleado(empl);
            return MovdRepositorio.save(movimiento);
        }).get();
        return true;
    }

    /*public List<MovDinero> porEmpresa(int id) {
        try {
            return empresaRepo.findById(id).map(emp -> {
                return MovdRepositorio.findByEmpresa(emp);
            }).get();
        }catch(Exception ex){
            System.out.println("Error"+ex);

        }
        return null;
    }*/
    public MovDinero actualizarCampo(int id, Map<Object,Object> movMap){
        MovDinero movimiento=MovdRepositorio.findById(id).get();
        movMap.forEach((key,value)->{
            Field campo= ReflectionUtils.findField(MovDinero.class,(String)key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, movimiento, value);
        });
        return MovdRepositorio.save(movimiento);
    }
    public String eliminarMovimiento(int id){
        if(buscarMovimiento(id).isPresent()){
            MovdRepositorio.deleteById(id);
            return "Movimiento eliminada";
        }else{
            return "Movimiento no existe";
        }
    }

    /*public List<MovDinero> movimientosEmpleado(Integer id) { //Obterner teniendo en cuenta el id del empleado
        return MovdRepositorio.findByEmpleado(id);
    }

    public List<MovDinero> movimientosEmpresa(Integer id) { //Obtener movimientos teniendo en cuenta el id de la empresa a la que pertencen los empleados que la registraron
        return MovdRepositorio.findByEmpresa(id);
    }*/
    public List<MovDinero> movimientosPorEmpleado(int id) {
        try {
            return empleadoRepo.findById(id).map(empl -> {
                return MovdRepositorio.findByEmpleado(empl);
            }).get();
        }catch(Exception ex){
            System.out.println("Error"+ex);

        }
        return null;
    }
    public List<MovDinero> movimientosPorEmpresa(int id) {
        try {
            return empresaRepo.findById(id).map(empr -> {
                return MovdRepositorio.findByEmpresa(empr);
            }).get();
        }catch(Exception ex){
            System.out.println("Error"+ex);

        }
        return null;
    }

    public Long obtenerSumaMontos(){
        return MovdRepositorio.SumarMontos();
    }

    public Long MontosPorEmpleado(Integer id){
        return MovdRepositorio.MontosPorEmpleado(id);
    }

    public Long MontosPorEmpresa(Integer id){
        return MovdRepositorio.MontosPorEmpresa(id);
    }

    public Integer IdPorCorreo(String Correo){
        return MovdRepositorio.IdPorCorreo(Correo);
    }

}














