package com.UdeA.IngreSoft.Entidad;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="movDinero")
public class MovDinero {

@Id
@Column(unique = true, length = 30)
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, length= 100)
    private java.lang.String concepto;
    @Column(nullable = false, length = 20)
    private float monto;
    @ManyToOne
   @JoinColumn(name = "empleadoId")
    private String empleado;
    @ManyToOne
    @JoinColumn(name = "empresaId")
    private Empresa empresa;
    @Column(nullable = false)
    private Date fecha;



    public MovDinero() {
    }

    public MovDinero(int id, java.lang.String concepto, float monto, String empleado, Empresa empresa, Date fecha) {
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

    public java.lang.String getConcepto() {
        return concepto;
    }

    public void setConcepto(java.lang.String concepto) {
        this.concepto = concepto;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
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
