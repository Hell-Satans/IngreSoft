package com.UdeA.IngreSoft.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Idempleado;

    @Column(unique = false, length = 30)
    private String correo;
    @JoinColumn(name = "empresaId")
    @ManyToOne
    @JsonIgnore
    private Empresa empresa;
    @OneToMany(mappedBy = "empleado",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

    public Empleado() {
    }

    public Empleado(int idempleado, String correo, Empresa empresa, List<MovDinero> transacciones, Date createdAt, Date updatedAt) {
        Idempleado = idempleado;
        this.correo = correo;
        this.empresa = empresa;
        this.transacciones = transacciones;
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

    @Override
    public String toString() {
        return "Empleado{" +
                "Idempleado=" + Idempleado +
                ", correo='" + correo + '\'' +
                ", empresa=" + empresa +
                ", transacciones=" + transacciones +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
