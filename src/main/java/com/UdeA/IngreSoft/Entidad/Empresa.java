package com.UdeA.IngreSoft.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private String nombre;
    @Column(nullable = false, length = 80)
    private String direccion;
    @Column(nullable = false, length = 30)
    private String telefono;
    @Column(unique = true, length = 30)
    private String nit;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private List<Empleado> usuarios;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
    //@PrePersist
    public void prePersistUpdate(){
        this.updatedAt=new Date();
    }
    public Empresa() {
    }



    public Empresa(int id, String nombre, String direccion, String telefono, String nit) {
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
    public String toString() {
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