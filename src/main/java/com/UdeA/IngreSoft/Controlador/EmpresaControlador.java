package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Servicios.EmpresaServicios;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
//@RequestMapping("/enterprises")
public class EmpresaControlador {

    private EmpresaServicios empresaServicios;

    public EmpresaControlador(EmpresaServicios empresaServicios) {
        this.empresaServicios = empresaServicios;
    }

    @GetMapping("/enterprises")
    private ResponseEntity<List<Empresa>> listarEmpresa(){
        return ResponseEntity.ok(empresaServicios.listarEmpresas());
    }
    /*@GetMapping("/enterprises/{id}")
    private ResponseEntity<Optional<Empresa>> listarId(@PathVariable ("id") int id){
        return ResponseEntity.ok(empresaServicios.buscarEmpresa(id));
    }
    @PostMapping("/empresas")
    private String agregarEmpresa(@RequestBody Empresa empresa){
        return empresaServicios.agregarEmpresa(empresa);
    }*/

    @PostMapping("/enterprises")
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody Empresa empresa) {
        try {
            Empresa empresaSave = empresaServicios.save(empresa);
            return ResponseEntity.created(new URI("/empresas" + empresaSave.getId())).body(empresaSave);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    /*@PutMapping("/ActualizarEmpresa")
    public String actualizarEmpresa(@RequestBody Empresa empresa){
        return empresaServicios.actualizarEmpresa(empresa);
    }

    @PatchMapping("/ActualizarDir/{id}/{dir}")
    public String actualizarDir(@PathVariable("id") int id, @PathVariable ("dir") String direccion){
        return empresaServicios.actualizarDireccion(id, direccion);
    }*/

    @PatchMapping("/enterprises/{id}")
    public Empresa actualizarCampo(@PathVariable("id")int id, @RequestBody Map<Object, Object> empresaMap){
        return empresaServicios.actualizarCampo(id,empresaMap);
    }

    @DeleteMapping("/enterprises/{id}")
    private ResponseEntity<String> eliminarEmpresa(@PathVariable("id") int id){

        return ResponseEntity.ok(empresaServicios.eliminarEmpresa(id));
    }

}
