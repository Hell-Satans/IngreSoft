package com.UdeA.IngreSoft;

public class date {
    private String fecha;
    private String dia;
    private String mes;
    private String anho;

    public date(String dia, String mes, String anho) {
        this.fecha = dia+"/"+mes+"/"+anho;
        this.dia = dia;
        this.mes = mes;
        this.anho = anho;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    @Override
    public String toString() {
        return fecha;
    }
}
