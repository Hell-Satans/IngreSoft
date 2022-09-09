package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Servicios.EmpresaServicios;
import com.UdeA.IngreSoft.Servicios.empleadoServicio;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoControlador {

  /* @GetMapping("/empleado")
    public List<Empleado>obtenerEmpleados(){
         Empleado empleado = new Empleado("juan","02","3113120202","gerente","juan@yahoo.com");
        ArrayList<Empleado>empleados=new ArrayList<>();
         empleados.add(empleado);
         return empleados;*/
  @Autowired
    private empleadoServicio servicio; public EmpleadoControlador(empleadoServicio servicio) {this.servicio = servicio;}



    @GetMapping("/Listarempleados")
    public ResponseEntity<List<Empleado>>listaEmpleado(){
        return ResponseEntity.ok(servicio.listaEmpleados());
    }
    @GetMapping("/ConsultarEmpleado/{id}")
    private ResponseEntity<Optional<Empleado>> listarId(@PathVariable("id") String id){
        return ResponseEntity.ok(servicio.buscarEmpleado(id));
    }
  @PostMapping("/AgregarEmpleado")
  private String agregarEmpleado(@RequestBody Empleado empleado){
    return servicio.agregarEmpleado(empleado);
  }
  @PutMapping("/ActualizarEmpleado")
  public String actualizarEmpleado(@RequestBody Empleado empleado){
    return servicio.actualizarEmpleado(empleado);
  }
  @PatchMapping("/ActualizarTel/{id}/{tel}")
  public String actualizarTel(@PathVariable("id") String id, @PathVariable ("tel") String telefono){
    return servicio.actualizarTelefono(id, telefono);
  }
  @DeleteMapping("/EliminarEmpleado")
  private ResponseEntity<String> eliminarEmpleado(@PathVariable("id") String id){

    return ResponseEntity.ok(servicio.eliminarEmpleado(id));
  }

}



