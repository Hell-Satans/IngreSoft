package com.UdeA.IngreSoft.Entidad;

public class Perfil {
    private java.lang.String idPerfil;
    private java.lang.String imagenPerfil;
    private Empleado telefono;
    private java.lang.String usuarioPerfil;
    private Empleado cargo;

    public Perfil() {
    }

    public Perfil(java.lang.String idPerfil, java.lang.String imagenPerfil, Empleado telefono, java.lang.String usuarioPerfil, Empleado cargo) {
        this.idPerfil = idPerfil;
        this.imagenPerfil = imagenPerfil;
        this.telefono = telefono;
        this.usuarioPerfil = usuarioPerfil;
        this.cargo = cargo;
    }

    public java.lang.String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(java.lang.String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public java.lang.String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(java.lang.String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public Empleado getTelefono() {
        return telefono;
    }

    public void setTelefono(Empleado telefono) {
        this.telefono = telefono;
    }

    public java.lang.String getUsuarioPerfil() {
        return usuarioPerfil;
    }

    public void setUsuarioPerfil(java.lang.String usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }

    public Empleado getCargo() {
        return cargo;
    }

    public void setCargo(Empleado cargo) {
        this.cargo = cargo;
    }

    @Override
    public java.lang.String toString() {
        return "Perfil{" +
                "idPerfil='" + idPerfil + '\'' +
                ", imagenPerfil='" + imagenPerfil + '\'' +
                ", telefono=" + telefono +
                ", usuarioPerfil='" + usuarioPerfil + '\'' +
                ", cargo=" + cargo +
                '}';
    }
}
