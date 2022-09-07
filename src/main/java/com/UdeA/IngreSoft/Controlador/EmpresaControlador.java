package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Servicios.EmpresaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
//@RequestMapping("/api/empresa")
public class EmpresaControlador {

   @Autowired
    private EmpresaServicios empresaServicios;

    public EmpresaControlador(EmpresaServicios empresaServicios) {
        this.empresaServicios = empresaServicios;
    }

    @GetMapping("/ListarEmpresas")
    private ResponseEntity<List<Empresa>> listarEmpresa(){
        return ResponseEntity.ok(empresaServicios.listarEmpresas());
    }
    @GetMapping("/ConsultarEmpresa/{id}")
    private ResponseEntity<Optional<Empresa>> listarId(@PathVariable ("id") String id){
        return ResponseEntity.ok(empresaServicios.buscarEmpresa(id));
    }
    @PostMapping("/AgregarEmpresa")
    private String agregarEmpresa(@RequestBody Empresa empresa){
        return empresaServicios.agregarEmpresa(empresa);
    }

    @PutMapping("/ActualizarEmpresa")
    public String actualizarEmpresa(@RequestBody Empresa empresa){
        return empresaServicios.actualizarEmpresa(empresa);
    }

    @PatchMapping("/ActualizarDir/{id}/{dir}")
    public String actualizarDir(@PathVariable("id") String id, @PathVariable ("dir") String direccion){
        return empresaServicios.actualizarDireccion(id, direccion);
    }

    @DeleteMapping("/EliminarEmpresa")
    private ResponseEntity<String> eliminarEmpresa(@PathVariable("id") String id){

        return ResponseEntity.ok(empresaServicios.eliminarEmpresa(id));
    }

}
