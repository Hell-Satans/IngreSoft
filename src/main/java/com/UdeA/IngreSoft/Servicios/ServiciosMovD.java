package com.UdeA.IngreSoft.Servicios;


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
    public List<MovDinero> movimientosDineroEmpresa(int id) {
        return  MovdRepositorio.findByEmpresaId(id);
    }

    public MovDinero agregarMovimiento(int id, int idempleado, MovDinero movimiento) {
        empresaRepo.findById(id).map(empresa -> {
            movimiento.setEmpresa(empresa);
            return empresa;
        });
        return empleadoRepo.findById(idempleado).map(empleado -> {
            movimiento.setEmpleado(empleado);
            return MovdRepositorio.save(movimiento);
        }).get();
    }

    public List<MovDinero> porEmpresa(int id) {
        try {
            return empresaRepo.findById(id).map(emp -> {
                return MovdRepositorio.findByEmpresa(emp);
            }).get();
        }catch(Exception ex){
            System.out.println("Error"+ex);

        }
        return null;
    }
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

}














