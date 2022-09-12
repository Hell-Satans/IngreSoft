package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.MovDinero;
import com.UdeA.IngreSoft.Servicios.ServiciosMovD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorMovD {
    @Autowired
    private ServiciosMovD servicio;

    @GetMapping ("/enterprises/{id}/movements")
    public List<MovDinero>movimientosDineroEmpresa (@PathVariable int id ){
        return servicio.movimientosDineroEmpresa (id);
    }

    @PostMapping ("/enterprises/{id}/movements")
    public MovDinero agregarMovimientoDinero (@PathVariable int id,@RequestBody MovDinero movimientoDinero){
        return servicio.agregarMovimientoDinero (id,movimientoDinero);
    }


    @PatchMapping("/enterprises/{id}/movements")
    public MovDinero actualizarMovDinero (@PathVariable int id ,@RequestBody MovDinero movimientoDinero){
        return servicio.actualizarMovDinero (id);
    }








        }








