package com.UdeA.IngreSoft.Entidad;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="movDinero")
public class MovDinero {

@Id
@Column(unique = true, length = 30)
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length= 100)
    private String concepto;
    @Column(nullable = false, length = 20)
    private float monto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empleadoId", referencedColumnName = "Idempleado",nullable = false)
    private Empleado empleado;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empresaId", referencedColumnName = "id",nullable = false)
    private Empresa empresa;C
    @Temporal(TemporalType.DATE)
    @Column
    private Date fecha;

    @Temporal(TemporalType.DATE)
    @Column
    private Date update;


    @PrePersist
    public void prePersist(){
        this.fecha=new Date();
    }
    //@PrePersist
    public void prePersistUpdate(){
        this.update=new Date();
    }

    public MovDinero() {
    }

    public MovDinero(int id, String concepto, float monto, Empleado empleado, Empresa empresa, Date fecha) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.empleado = empleado;
        this.empresa = empresa;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
