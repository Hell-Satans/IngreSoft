package com.UdeA.IngreSoft.Entidad;

public class Perfil {
    private java.lang.String idPerfil;
    private java.lang.String imagenPerfil;
    private String telefono;
    private java.lang.String usuarioPerfil;
    private String cargo;

    public Perfil() {
    }

    public Perfil(java.lang.String idPerfil, java.lang.String imagenPerfil, String telefono, java.lang.String usuarioPerfil, String cargo) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public java.lang.String getUsuarioPerfil() {
        return usuarioPerfil;
    }

    public void setUsuarioPerfil(java.lang.String usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
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
