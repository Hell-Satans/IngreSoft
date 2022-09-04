package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Servicios.EmpresaServicios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaControlador {

    private EmpresaServicios empresaServicios;

    public EmpresaControlador(EmpresaServicios empresaServicios) {
        this.empresaServicios = empresaServicios;
    }

    @PostMapping
    private ResponseEntity<Empresa> guardar (Empresa empresa){
        Empresa empresa1= empresaServicios.crearEmpresa(empresa);
        try{
            return ResponseEntity.created(new URI("/api/empresa"+empresa1.getId())).body(empresa1);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/ListarEmpresas")
    private ResponseEntity<List<Empresa>> listarEmpresa(){
        return ResponseEntity.ok(empresaServicios.getAllEmpresas());
    }

    @DeleteMapping("/Eliminar")
    private ResponseEntity<Void> eliminarEmpresa(@RequestBody Empresa empresa){
        empresaServicios.delete(empresa);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/ConsultarEmpresa/{Id}")
    private ResponseEntity<Optional<Empresa>> listarId(@PathVariable ("Id") String Id){
        return ResponseEntity.ok(empresaServicios.buscarId(Id));
    }
}
