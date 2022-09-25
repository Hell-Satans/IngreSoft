package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Entidad.MovDinero;
import com.UdeA.IngreSoft.Servicios.ServiciosMovD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ControladorMovD {
    @Autowired
    private ServiciosMovD servicio;

    public ControladorMovD(ServiciosMovD servicio) {
        this.servicio = servicio;
    }

    @GetMapping ("/enterprises/{id}/movements")
    public List<MovDinero>movimientosDineroEmpresa (@PathVariable int id ){
        return servicio.movimientosDineroEmpresa (id);
    }

    @GetMapping("/movements/{id}")
    private ResponseEntity<Optional<MovDinero>> listarId(@PathVariable ("id") int id){
        return ResponseEntity.ok(servicio.buscarMovimiento(id));
    }

    /*@PostMapping ("/enterprises/{id}/movements")
    public MovDinero agregarMovimientoDinero (@PathVariable int id,@RequestBody MovDinero movimientoDinero){
        return servicio.agregarMovimientoDinero (id,movimientoDinero);
    }


    @PatchMapping("/enterprises/{id}/movements")
    public MovDinero actualizarMovDinero (@PathVariable int id ,@RequestBody MovDinero movimientoDinero){
        return servicio.actualizarMovDinero (id);
    }*/

    @PostMapping("movements/{id}/{id_em}")
    public MovDinero agregarMovimiento(@PathVariable("id")int id, @PathVariable("id_em")int idEmpleado, @RequestBody MovDinero movimiento){
        return servicio.agregarMovimiento(id,idEmpleado,movimiento);
    }

    @GetMapping("/porEmpresa/{id}")
    public List<MovDinero> porEmpresa(@PathVariable("id")int id){
        return servicio.porEmpresa(id);
    }


    @PatchMapping("/enterprises/{id}/movement")
    public MovDinero actualizarCampo(@PathVariable("id")int id, @RequestBody Map<Object, Object> movimientoMap){
        return servicio.actualizarCampo(id,movimientoMap);
    }

    @DeleteMapping("movements/{id}")
    private ResponseEntity<String> eliminarMovimiento(@PathVariable("id") int id){

        return ResponseEntity.ok(servicio.eliminarMovimiento(id));
    }


}









