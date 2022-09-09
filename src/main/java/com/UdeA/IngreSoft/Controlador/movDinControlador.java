package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Entidad.MovDinero;
import com.UdeA.IngreSoft.Servicios.EmpresaServicios;
import com.UdeA.IngreSoft.Servicios.mdServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class movDinControlador {
    @Autowired
    private mdServicios servicio;


    public  movDinControlador(mdServicios servicio){
        this.servicio=servicio;
    }

    @GetMapping("/Listar empresas")
    public List<Empresa>)listar(){
        return servicio.listarEmpresas();
    }

    @GetMapping("/Buscar empleado/{empleadoId}")
    List<Empresa>buscarEmpleado(@PathVariable("empleado")String empleado) {
    return servicio.buscarEmpleado(empleado);
     }

     @PostMapping("/Agregar concepto")
    public String agregar concepto(@RequestBody  Empresa concepto){
    return servicio.agregarConcepto(Empresa);
    }



    }





