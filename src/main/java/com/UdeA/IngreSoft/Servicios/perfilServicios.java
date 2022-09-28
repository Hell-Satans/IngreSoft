package com.UdeA.IngreSoft.Servicios;

import com.UdeA.IngreSoft.Entidad.Perfil;
import com.UdeA.IngreSoft.Repositorio.PerfilRepositorio;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public class perfilServicios {
    PerfilRepositorio perfilRepositorio;

    public perfilServicios(PerfilRepositorio perfilRepositorio) {
        this.perfilRepositorio = perfilRepositorio;
    }
    public Perfil agregarUsuario(Perfil user){
        return perfilRepositorio.save(user);
    }

    public Perfil buscarCorreo(String email){
        return  perfilRepositorio.findByEmail(email);
    }
    public Perfil comprobarUsuario(Map<String,Object> datos){
        Perfil user=buscarCorreo((String)datos.get("email"));
        if(user==null){
            String name= (String) datos.get("name");
            String imagen= (String) datos.get("picture");
            String authId= (String) datos.get("sub");
            String correo= (String) datos.get("email");
            Perfil usuario= new Perfil(correo,name,imagen,authId);
            user=agregarUsuario(usuario);
            return user;
        }else{
            return user;
        }
    }
}
