package com.UdeA.IngreSoft;

public class Perfil {
    private String id;
    private String imagen;
    private String telefono;

    public Perfil(String id, String imagen, String telefono) {
        this.id = id;
        this.imagen = imagen;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
