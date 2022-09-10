package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Servicios.empleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private ResponseEntity<Optional<Empleado>> listarId(@PathVariable("id") java.lang.String id){
        return ResponseEntity.ok(servicio.buscarEmpleado(id));
    }
  @PostMapping("/AgregarEmpleado")
  private java.lang.String agregarEmpleado(@RequestBody Empleado empleado){
    return servicio.agregarEmpleado(empleado);
  }
  @PutMapping("/ActualizarEmpleado")
  public java.lang.String actualizarEmpleado(@RequestBody Empleado empleado){
    return servicio.actualizarEmpleado(empleado);
  }
  @PatchMapping("/ActualizarTel/{id}/{tel}")
  public java.lang.String actualizarTel(@PathVariable("id") java.lang.String id, @PathVariable ("tel") java.lang.String telefono){
    return servicio.actualizarTelefono(id, telefono);
  }
  @DeleteMapping("/EliminarEmpleado")
  private ResponseEntity<java.lang.String> eliminarEmpleado(@PathVariable("id") java.lang.String id){

    return ResponseEntity.ok(servicio.eliminarEmpleado(id));
  }

}



