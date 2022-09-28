package com.UdeA.IngreSoft.Servicios;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Entidad.MovDinero;
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
    public Empleado buscarEmpleado2(int idempleado){
        return repositorio.findById(idempleado).get();
    }
    public List<Empleado> porEmpresa(Empresa emp){
        return repositorio.findByEmpresa(emp);
    }
    public <S extends Empleado> S save(S entidad){
        return repositorio.save(entidad);
    }

    public boolean agregarEmpleador(int id, Empleado empleado){
        empresaRepositorio.findById(id).map(emp->{
            empleado.setEmpresa(emp);
            return repositorio.save(empleado);
        }).get();
        return true;
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

    public String eliminarEmpleado(int id){
        if(buscarEmpleado(id).isPresent()){
            repositorio.deleteById(id);
            return "Empleaso  eliminado";
        }else{
            return "El empleado no existe";
        }
    }

    public boolean agregarEmpleado(Empleado empl){
        Empleado emp=repositorio.save(empl);
        if (repositorio.findById(emp.getIdempleado())!=null){
            return true;
        }
        return false;
    }
    public List<Empleado> empleadosEmpresa(int id) {
        try {
            return empresaRepositorio.findById(id).map(emp -> {
                return repositorio.findByEmpresa(emp);
            }).get();
        }catch(Exception ex){
            System.out.println("Error"+ex);

        }
        return null;
    }
}
