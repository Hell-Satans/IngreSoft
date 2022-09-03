package com.UdeA.IngreSoft.Entidad;

import com.UdeA.IngreSoft.Entidad.Empresa;

public class Empleado {

    private String nombre;
    private String Idempleado;
    private String telefono;
    private String cargo;
    private String correo;
    private Empresa empleado;

    public Empleado(String nombre, String idempleado, String telefono, String cargo, String correo) {
        this.nombre = nombre;
        Idempleado = idempleado;
        this.telefono = telefono;
        this.cargo = cargo;
        this.correo = correo;
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
}
