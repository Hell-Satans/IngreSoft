package com.UdeA.IngreSoft.Entidad;

public class Perfil {
    private String idPerfil;
    private String imagenPerfil;
    private Empleado telefono;
    private String usuarioPerfil;
    private Empleado cargo;

    public Perfil() {
    }

    public Perfil(String idPerfil, String imagenPerfil, Empleado telefono, String usuarioPerfil, Empleado cargo) {
        this.idPerfil = idPerfil;
        this.imagenPerfil = imagenPerfil;
        this.telefono = telefono;
        this.usuarioPerfil = usuarioPerfil;
        this.cargo = cargo;
    }

    public String getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(String idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getImagenPerfil() {
        return imagenPerfil;
    }

    public void setImagenPerfil(String imagenPerfil) {
        this.imagenPerfil = imagenPerfil;
    }

    public Empleado getTelefono() {
        return telefono;
    }

    public void setTelefono(Empleado telefono) {
        this.telefono = telefono;
    }

    public String getUsuarioPerfil() {
        return usuarioPerfil;
    }

    public void setUsuarioPerfil(String usuarioPerfil) {
        this.usuarioPerfil = usuarioPerfil;
    }

    public Empleado getCargo() {
        return cargo;
    }

    public void setCargo(Empleado cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "idPerfil='" + idPerfil + '\'' +
                ", imagenPerfil='" + imagenPerfil + '\'' +
                ", telefono=" + telefono +
                ", usuarioPerfil='" + usuarioPerfil + '\'' +
                ", cargo=" + cargo +
                '}';
    }
}
