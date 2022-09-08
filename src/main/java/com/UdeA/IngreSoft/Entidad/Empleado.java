package com.UdeA.IngreSoft.Entidad;

import com.UdeA.IngreSoft.Entidad.Empresa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Empleado")
public class Empleado {

    @Column(unique = false, length = 30)
    private String nombre;
    @Id
    @Column(unique = true, length = 30)
    private String Idempleado;
    @Column(unique = false, length = 30)
    private String telefono;
    @Column(unique = false, length = 30)
    private String cargo;
    @Column(unique = false, length = 30)
    private String correo;

    @Column(unique = false, length = 30)
    private Empresa empleado;

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
