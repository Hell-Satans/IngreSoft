package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Servicios.empleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
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



  @GetMapping("/user")
  public ResponseEntity<List<Empleado>>listaEmpleado(){
    return ResponseEntity.ok(servicio.listaEmpleados());
  }
  @GetMapping("/user/{id}")
  private ResponseEntity<Optional<Empleado>> listarId(@PathVariable("id") int id){
    return ResponseEntity.ok(servicio.buscarEmpleado(id));
  }
  /*@PostMapping("/user")
  private java.lang.String agregarEmpleado(@RequestBody Empleado empleado){
    return servicio.agregarEmpleado(empleado);
  }*/
  /*@PostMapping("/users/{id}")
  public Empleado agregarEmple(@PathVariable("id") int id, @RequestBody Empleado empleado){
    return  servicio.agregarEmpleador(id,empleado);
  }*/
  @PostMapping("/user")
  public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado) {
    try {
      Empleado empleadoSave = servicio.save(empleado);
      return ResponseEntity.created(new URI("/user" + empleadoSave.getIdempleado())).body(empleadoSave);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }
  /*@PutMapping("/ActualizarEmpleado")
  public java.lang.String actualizarEmpleado(@RequestBody Empleado empleado){
    return servicio.actualizarEmpleado(empleado);
  }*/
  @PatchMapping("/user/{id}")
  public Empleado actualizarCampo(@PathVariable("id")int id, @RequestBody Map<Object, Object> empleadoMap){
    return servicio.actualizarCampo(id,empleadoMap);
  }

  @DeleteMapping("/user/{id}")
  private ResponseEntity<java.lang.String> eliminarEmpleado(@PathVariable("id") int id){

    return ResponseEntity.ok(servicio.eliminarEmpleado(id));
  }

}



