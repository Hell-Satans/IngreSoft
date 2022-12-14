package com.UdeA.IngreSoft.Entidad;

import javax.persistence.*;

@Entity
@Table(name = "Usuario")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String nick;
    @Column(unique = true)
    private String imagen;
    @Column(unique = true)
    private String auth_id;

    public Perfil() {
    }

    public Perfil(String email, String nick, String imagen, String auth_id) {
        this.id=id;
        this.email = email;
        this.nick = nick;
        this.imagen = imagen;
        this.auth_id = auth_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(String auth_id) {
        this.auth_id = auth_id;
    }
}
