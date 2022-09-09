package com.UdeA.IngreSoft.Servicios;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Repositorio.empleadoRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class empleadoServicio {
    private empleadoRepositorio repositorio;

    public empleadoServicio(empleadoRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public List<Empleado> listaEmpleados(){ return (List<Empleado>)repositorio.findAll();}//Consutar todos los empleados
    public Optional<Empleado> buscarEmpleado(String Idempleado) {return repositorio.findById(Idempleado); }

    public String agregarEmpleado(Empleado empleado) {
        if (!buscarEmpleado(empleado.getIdempleado()).isPresent()) {
            repositorio.save(empleado);
            return "El empleadoa sido registrado con éxito";
        } else {
            return "El empleado ya existe";
        }
    }

    public String actualizarEmpleado(Empleado empleado){
        if (!buscarEmpleado(empleado.getIdempleado()).isPresent()){
            repositorio.save(empleado);
            return "El empleado  se actualizo con éxito";
        }else{
            return "El empleado no existe.";
        }
    }

    public String actualizarTelefono(String id, String telefono){
        if(buscarEmpleado(id).isPresent()){
            Empleado empleado=repositorio.findById(id).get();
            empleado.setTelefono(telefono);
            repositorio.save(empleado);
            return "Telefono Actualizado";
        }else{
            return "El empleado no existe";
        }
    }

    public String eliminarEmpleado(String id){
        if(buscarEmpleado(id).isPresent()){
            repositorio.deleteById(id);
            return "Empleaso  eliminado";
        }else{
            return "El empleado no existe";
        }
    }
}
