package com.UdeA.IngreSoft.Entidad;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Empresa")
public class Empresa {

    @Id
    @Column(unique = true, length = 30)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String Id;
    @Column(unique = true, length = 100)
    private String nombre;
    @Column(nullable = false, length = 80)
    private String direccion;
    @Column(nullable = false, length = 30)
    private String telefono;
    @Column(unique = true, length = 30)
    private String nit;

    @OneToMany(mappedBy = "empresa")


    private List<Empleado> usuarios;

    @OneToMany(mappedBy = "empresa")
    private List<MovDinero> transacciones;
   /* @Column(name = "Fecha Creado")
    private Date createdAt;
    @Column(name = "Fecha Actualizado")
    private Date updatedAt;*/

    public Empresa() {
    }

    public Empresa(String id, String nombre, String direccion, String telefono, String nit) {
        Id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

   /* public ArrayList<Empleado> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Empleado> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<MovDinero> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(ArrayList<MovDinero> transacciones) {
        this.transacciones = transacciones;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }*/

    @Override
    public String toString() {
        return "Empresa{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nit='" + nit + '\'' +
                '}';
    }
}