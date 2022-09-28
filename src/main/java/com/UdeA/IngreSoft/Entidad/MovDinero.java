package com.UdeA.IngreSoft.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

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
    private Long monto;
    @Column(name = "tipo")
    private String tipo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empleadoId", referencedColumnName = "idempleado",nullable = false)
    private Empleado empleado;
    /*@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empresaId", referencedColumnName = "id")
    private Empresa empresa;*/
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

    public MovDinero(int id, String concepto, Long monto, String tipo, Empleado empleado, Date fecha, Date update) {
        this.id = id;
        this.concepto = concepto;
        this.monto=monto;
        this.tipo = tipo;
        this.empleado = empleado;
        this.fecha = fecha;
        this.update = update;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
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

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /*public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }*/

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long egreso(String tipo){
        Long cantidad;
        if(tipo.equalsIgnoreCase("Egreso")){
            cantidad=-monto;
        }else{
            cantidad=monto;
        }return cantidad;
    }


}
