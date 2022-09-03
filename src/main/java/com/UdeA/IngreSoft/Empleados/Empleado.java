package com.UdeA.IngreSoft.Empleados;

public class Empleado {

    private String nombre;
    private String Idempleado;
    private String telefono;
    private String cargo;
    private String correo;

    public Empleado(String nombre, String idempleado, String telefono, String cargo, String correo) {
        this.nombre = nombre;
        Idempleado = idempleado;
        this.telefono = telefono;
        this.cargo = cargo;
        this.correo = correo;
    }

    public Empleado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdempleado() {
        return Idempleado;
    }

    public void setIdempleado(String idempleado) {
        Idempleado = idempleado;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", Idempleado='" + Idempleado + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cargo='" + cargo + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
