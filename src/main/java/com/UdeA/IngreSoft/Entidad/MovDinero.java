package com.UdeA.IngreSoft.Entidad;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;


import javax.persistence.*;
import java.util.Date;

@Table(name="movDinero")
public class MovDinero {

@Id
@Column(unique = true, length = 30)
@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(unique = true, length = 100)
    private String concepto;
    @Column(nullable = false, length = 20)
    private float monto;
    @Column(unique = true, length = 40)
    private Empleado empleado;
    @Column(unique = true, length = 30)
    private Empresa empresa;
    private Date fecha;


    public MovDinero(String id, String concepto, float monto, Empleado empleado, Empresa empresa, Date fecha) {
        this.id = id;
        this.concepto = concepto;
        this.monto = monto;
        this.empleado = empleado;
        this.empresa = empresa;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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