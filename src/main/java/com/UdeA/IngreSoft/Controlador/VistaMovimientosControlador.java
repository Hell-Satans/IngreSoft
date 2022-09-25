package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.MovDinero;
import com.UdeA.IngreSoft.Servicios.EmpresaServicios;
import com.UdeA.IngreSoft.Servicios.ServiciosMovD;
import com.UdeA.IngreSoft.Servicios.empleadoServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VistaMovimientosControlador {

    ServiciosMovD servicioMovimientos;
    empleadoServicio empleadoServicio;
    EmpresaServicios empresaServicios;

    public VistaMovimientosControlador(ServiciosMovD servicioMovimientos, com.UdeA.IngreSoft.Servicios.empleadoServicio empleadoServicio, EmpresaServicios empresaServicios) {
        this.servicioMovimientos = servicioMovimientos;
        this.empleadoServicio = empleadoServicio;
        this.empresaServicios = empresaServicios;
    }

    @GetMapping("/Movimientos")
    public String prueba(Model model){
        List<MovDinero> lista=this.servicioMovimientos.listarMovimientos();
        model.addAttribute("lista",lista);
        return "Movimientos";
    }
}
