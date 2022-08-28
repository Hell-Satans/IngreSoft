package com.UdeA.IngreSoft.Empleados;

public class Empleado {

    private String nombre;
    private String Id;
    private String telefono;
    private String cargo;
    private String correo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Empleado(String nombre, String id, String telefono, String cargo, String correo) {
        this.nombre = nombre;
        this.Id = id;
        this.telefono = telefono;
        this.cargo = cargo;
        this.correo = correo;
    }
}
