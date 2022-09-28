package com.UdeA.IngreSoft.Servicios;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Repositorio.EmpresaRepositorio;
import com.UdeA.IngreSoft.Repositorio.empleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmpresaServicios {
    @Autowired
    EmpresaRepositorio empresaRepo;
    empleadoRepositorio empleadoRepositorio;

    public EmpresaServicios(EmpresaRepositorio empresaRepo, com.UdeA.IngreSoft.Repositorio.empleadoRepositorio empleadoRepositorio) {
        this.empresaRepo = empresaRepo;
        this.empleadoRepositorio = empleadoRepositorio;
    }

    public List<Empresa> listarEmpresas(){
        List<Empresa> empresaList = new ArrayList<>();
        empresaRepo.findAll().forEach(empresa -> empresaList.add(empresa));
        return empresaList;
    }
    public Empresa buscarEmpresa(int Id) {
        return empresaRepo.findById(Id).get();
    }

    public Optional<Empresa> buscarEmpresa1(int id){
        return empresaRepo.findById(id);
    }
    public Empresa empresaEmpleado(int id) {
        try {
            return empleadoRepositorio.findById(id).map(empl -> {
                return empresaRepo.findByEmpleado(empl);
            }).get();
        }catch(Exception ex){
            System.out.println("Error"+ex);

        }
        return null;
    }
    public <S extends Empresa> S save(S entidad){
        return empresaRepo.save(entidad);
    }

    public boolean saveEmpresa(Empresa empresa){
        Empresa emp=empresaRepo.save(empresa);
        if (empresaRepo.findById(emp.getId())!=null){
            return true;
        }
        return false;
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
    public boolean eliminarEmpresa(int id){
        if(buscarEmpresa1(id).isPresent()){
            empresaRepo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
