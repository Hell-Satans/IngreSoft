package com.UdeA.IngreSoft.Servicios;

import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Repositorio.EmpresaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServicios {

    private EmpresaRepositorio empresaRepo;

    public EmpresaServicios(EmpresaRepositorio empresaRepo) {
        this.empresaRepo = empresaRepo;
    }
    public List<Empresa> listarEmpresas(){
        return (List<Empresa>)empresaRepo.findAll();
    }
    public Optional<Empresa> buscarEmpresa(String Id) {
        return empresaRepo.findById(Id);
    }

    public String agregarEmpresa(Empresa empresa) {
        if (!buscarEmpresa(empresa.getId()).isPresent()) {
            empresaRepo.save(empresa);
            return "Empresa registrada con éxito";
        } else {
            return "La empresa ya existe";
        }
    }

    public String actualizarEmpresa(Empresa empresa){
        if(buscarEmpresa(empresa.getId()).isPresent()){
            empresaRepo.save(empresa);
            return "La empresa se actualizo con éxito";
        }else{
            return "La empresa no existe.";
        }
    }

    public String actualizarDireccion(String id, String direccion){
        if(buscarEmpresa(id).isPresent()){
            Empresa empresa=empresaRepo.findById(id).get();
            empresa.setDireccion(direccion);
            empresaRepo.save(empresa);
            return "Direccion Actualizada";
        }else{
            return "La empresa no existe";
        }
    }
    public String eliminarEmpresa(String id){
        if(buscarEmpresa(id).isPresent()){
            empresaRepo.deleteById(id);
            return "Empresa eliminada";
        }else{
            return "Empresa no existe";
        }
    }
}
