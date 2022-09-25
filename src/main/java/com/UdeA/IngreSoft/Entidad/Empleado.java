package com.UdeA.IngreSoft.Entidad;

import com.UdeA.IngreSoft.Entidad.enumeration.EnumRol;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Idempleado;
    private String nombre;

    private String telefono;
    @Column(unique = true)
    private String correo;
    @JoinColumn(name = "empresaId")
    @ManyToOne
    @JsonIgnore
    private Empresa empresa;
    @OneToMany(mappedBy = "empleado",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MovDinero> transacciones;

    @Enumerated
    @Column(name = "rol")
    private EnumRol rol;
    private String contraseña;
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

    public Empleado() {
    }

    public Empleado(int idempleado, String nombre, String telefono, String correo, Empresa empresa, List<MovDinero> transacciones, EnumRol rol, String contraseña, Date createdAt, Date updatedAt) {
        Idempleado = idempleado;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.empresa = empresa;
        this.transacciones = transacciones;
        this.rol = rol;
        this.contraseña = contraseña;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getIdempleado() {
        return Idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.Idempleado = idempleado;
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

    public List<MovDinero> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<MovDinero> transacciones) {
        this.transacciones = transacciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public EnumRol getRol() {
        return rol;
    }

    public void setRol(EnumRol rol) {
        this.rol = rol;
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

    //@Override
    /*public String toString() {
        return "Empleado{" +
                "Idempleado=" + Idempleado +
                ", correo='" + correo + '\'' +
                ", empresa=" + empresa +
                ", transacciones=" + transacciones +

                ", rol=" + rol +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }*/
}
