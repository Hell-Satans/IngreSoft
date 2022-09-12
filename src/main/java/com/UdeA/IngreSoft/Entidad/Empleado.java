package com.UdeA.IngreSoft.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="Empleado")
public class Empleado {

    @Column(unique = false, length = 30)
    private String nombre;
    @Id
    @Column(unique = true, length = 30)
    private int Idempleado;
    @Column(unique = false, length = 30)
    private String telefono;
    @Column(unique = false, length = 30)
    private String cargo;
    @Column(unique = false, length = 30)
    private String correo;


    @JoinColumn(name = "empresaId")
    @ManyToOne
    @JsonIgnore
    private Empresa empresa;

    public Empleado() {
    }

    public Empleado(String nombre, int idempleado, String telefono, String cargo, String correo, Empresa empresa) {
        this.nombre = nombre;
        this.Idempleado = idempleado;
        this.telefono = telefono;
        this.cargo = cargo;
        this.correo = correo;
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdempleado() {
        return Idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.Idempleado = idempleado;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", Idempleado=" + Idempleado +
                ", telefono='" + telefono + '\'' +
                ", cargo='" + cargo + '\'' +
                ", correo='" + correo + '\'' +
                ", empresa=" + empresa +
                '}';
    }
}
