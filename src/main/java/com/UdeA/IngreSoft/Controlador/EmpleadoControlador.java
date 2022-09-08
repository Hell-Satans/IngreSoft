package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Servicios.empleadoServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpleadoControlador {

  /* @GetMapping("/empleado")
    public List<Empleado>obtenerEmpleados(){
         Empleado empleado = new Empleado("juan","02","3113120202","gerente","juan@yahoo.com");
        ArrayList<Empleado>empleados=new ArrayList<>();
         empleados.add(empleado);
         return empleados;*/

    private empleadoServicio servicio;

    public EmpleadoControlador(empleadoServicio servicio) {
        this.servicio = servicio;
    }
    @GetMapping("/empleados")
    public ArrayList<Empleado> listar(){
        return servicio.listaEmpleados();
    }
}



