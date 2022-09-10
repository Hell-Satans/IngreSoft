package com.UdeA.IngreSoft.Entidad;

import javax.persistence.*;

@Entity
@Table(name="Empleado")
public class Empleado {

    @Column(unique = false, length = 30)
    private java.lang.String nombre;
    @Id
    @Column(unique = true, length = 30)
    private java.lang.String Idempleado;
    @Column(unique = false, length = 30)
    private java.lang.String telefono;
    @Column(unique = false, length = 30)
    private java.lang.String cargo;
    @Column(unique = false, length = 30)
    private java.lang.String correo;


    @JoinColumn(name = "empresaId")
    @ManyToOne
    private Empresa empresa;

    public Empleado(java.lang.String nombre, java.lang.String idempleado, java.lang.String telefono, java.lang.String cargo, java.lang.String correo) {
        this.nombre = nombre;
        Idempleado = idempleado;
        this.telefono = telefono;
        this.cargo = cargo;
        this.correo = correo;
    }

    public Empleado() {
    }

    public java.lang.String getNombre() {
        return nombre;
    }

    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    public java.lang.String getIdempleado() {
        return Idempleado;
    }

    public void setIdempleado(java.lang.String idempleado) {
        Idempleado = idempleado;
    }

    public java.lang.String getTelefono() {
        return telefono;
    }

    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }

    public java.lang.String getCargo() {
        return cargo;
    }

    public void setCargo(java.lang.String cargo) {
        this.cargo = cargo;
    }

    public java.lang.String getCorreo() {
        return correo;
    }

    public void setCorreo(java.lang.String correo) {
        this.correo = correo;
    }

    @Override
    public java.lang.String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", Idempleado='" + Idempleado + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cargo='" + cargo + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
