package com.UdeA.IngreSoft.Servicios;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Repositorio.EmpresaRepositorio;
import com.UdeA.IngreSoft.Repositorio.empleadoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class empleadoServicio {
    private empleadoRepositorio repositorio;
    private EmpresaRepositorio empresaRepositorio;

    public empleadoServicio(empleadoRepositorio repositorio, EmpresaRepositorio empresaRepositorio) {
        this.repositorio = repositorio;
        this.empresaRepositorio = empresaRepositorio;
    }

    public List<Empleado> listaEmpleados(){ return (List<Empleado>)repositorio.findAll();}//Consutar todos los empleados
    public Optional<Empleado> buscarEmpleado(int Idempleado) {return repositorio.findById(Idempleado); }

    public java.lang.String agregarEmpleado(Empleado empleado) {
        if (!buscarEmpleado(empleado.getIdempleado()).isPresent()) {
            repositorio.save(empleado);
            return "El empleado ha sido registrado con éxito";
        } else {
            return "El empleado ya existe";
        }
    }

    public <S extends Empleado> S save(S entidad){
        return repositorio.save(entidad);
    }

    public Empleado agregarEmpleador(int id, Empleado empleado){
        return empresaRepositorio.findById(id).map(emp->{
            empleado.setEmpresa(emp);
            return repositorio.save(empleado);
        }).get();
    }

    public java.lang.String actualizarEmpleado(Empleado empleado){
        if (!buscarEmpleado(empleado.getIdempleado()).isPresent()){
            repositorio.save(empleado);
            return "El empleado  se actualizo con éxito";
        }else{
            return "El empleado no existe.";
        }
    }

    public Empleado actualizarCampo(int id, Map<Object,Object> empleadoMap){
        Empleado empleado=repositorio.findById(id).get();
        empleadoMap.forEach((key,value)->{
            Field campo= ReflectionUtils.findField(Empleado.class,(String)key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, empleado, value);
        });
        return repositorio.save(empleado);
    }

    public java.lang.String eliminarEmpleado(int id){
        if(buscarEmpleado(id).isPresent()){
            repositorio.deleteById(id);
            return "Empleaso  eliminado";
        }else{
            return "El empleado no existe";
        }
    }
}
