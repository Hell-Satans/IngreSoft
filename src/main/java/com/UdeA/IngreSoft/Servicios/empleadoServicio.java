package com.UdeA.IngreSoft.Servicios;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Repositorio.empleadoRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class empleadoServicio {
    private empleadoRepositorio repositorio;

    public empleadoServicio(empleadoRepositorio repositorio) {
        this.repositorio = repositorio;
    }
    public ArrayList<Empleado> listaEmpleados(){ //Consutar todos los empleados
       return (ArrayList<Empleado>)repositorio.findAll();
    }
}
