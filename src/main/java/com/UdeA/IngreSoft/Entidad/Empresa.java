package com.UdeA.IngreSoft.Entidad;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Empresa")
public class Empresa {

    @Id
    @Column(unique = true, length = 30)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(unique = true, length = 100)
    private java.lang.String nombre;
    @Column(nullable = false, length = 80)
    private java.lang.String direccion;
    @Column(nullable = false, length = 30)
    private java.lang.String telefono;
    @Column(unique = true, length = 30)
    private java.lang.String nit;

    @OneToMany(mappedBy = "empresa")
    private List<Empleado> usuarios;
 
    @OneToMany(mappedBy = "empresa")
    private List<MovDinero> transacciones;
    @Temporal(TemporalType.DATE)
    @Column//(nullable = false)
    private Date createdAt;
    @Temporal(TemporalType.DATE)
    @Column
    private Date updatedAt;

    @PrePersist
    public void prePersist(){
        this.createdAt=new Date();
    }
    public Empresa() {
    }

    public Empresa(int id, java.lang.String nombre, java.lang.String direccion, java.lang.String telefono, java.lang.String nit) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nit = nit;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getNombre() {
        return nombre;
    }

    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    public java.lang.String getDireccion() {
        return direccion;
    }

    public void setDireccion(java.lang.String direccion) {
        this.direccion = direccion;
    }

    public java.lang.String getTelefono() {
        return telefono;
    }

    public void setTelefono(java.lang.String telefono) {
        this.telefono = telefono;
    }

    public java.lang.String getNit() {
        return nit;
    }

    public void setNit(java.lang.String nit) {
        this.nit = nit;
    }

    public List<Empleado> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Empleado> usuarios) {
        this.usuarios = usuarios;
    }

    public List<MovDinero> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<MovDinero> transacciones) {
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
    }
    @Override
    public java.lang.String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nit='" + nit + '\'' +
                ", usuarios=" + usuarios +
                ", transacciones=" + transacciones +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}