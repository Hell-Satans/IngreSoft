package com.UdeA.IngreSoft.Servicios;

import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Repositorio.EmpresaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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
    public Optional<Empresa> buscarEmpresa(int Id) {
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

    public <S extends Empresa> S save(S entidad){
        return empresaRepo.save(entidad);
    }

    public String actualizarEmpresa(Empresa empresa){
        if(buscarEmpresa(empresa.getId()).isPresent()){
            empresaRepo.save(empresa);
            return "La empresa se actualizó con éxito";
        }else{
            return "La empresa no existe.";
        }
    }

    public String actualizarDireccion(int id, String direccion){
        if(buscarEmpresa(id).isPresent()){
            Empresa empresa=empresaRepo.findById(id).get();
            empresa.setDireccion(direccion);
            empresaRepo.save(empresa);
            return "Direccion Actualizada";
        }else{
            return "La empresa no existe";
        }
    }

    public Empresa actualizarCampo(int id, Map<Object,Object> empresaMap){
        Empresa empresa=empresaRepo.findById(id).get();
        empresaMap.forEach((key,value)->{
            Field campo= ReflectionUtils.findField(Empresa.class,(String)key);
            campo.setAccessible(true);
            ReflectionUtils.setField(campo, empresa, value);
        });
        return empresaRepo.save(empresa);
    }
    public String eliminarEmpresa(int id){
        if(buscarEmpresa(id).isPresent()){
            empresaRepo.deleteById(id);
            return "Empresa eliminada";
        }else{
            return "Empresa no existe";
        }
    }
}
