package com.UdeA.IngreSoft.Servicios;

import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Repositorio.EmpresaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServicios {

    private EmpresaRepositorio EmpresaRepo;

    public Empresa crearEmpresa(Empresa empresa) {
        return EmpresaRepo.save(empresa);
    }

    public List<Empresa> getAllEmpresas(){
        return EmpresaRepo.findAll();
    }

    public void delete (Empresa empresa){
        EmpresaRepo.delete(empresa);
    }

    public Optional<Empresa> buscarId(String Id) {
        return EmpresaRepo.findById(Id);
    }

}
