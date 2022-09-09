package com.UdeA.IngreSoft.Servicios;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Entidad.MovDinero;
import com.UdeA.IngreSoft.Repositorio.EmpresaRepositorio;
import com.UdeA.IngreSoft.Repositorio.mdRepositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class mdServicios {
    private mdRepositorio MovdRepositorio;


    public mdServicios(mdRepositorio MovdRepositorio) {
        this.MovdRepositorio = MovdRepositorio;
    }


    public List<MovDinero> listarEmpresas() {
        return (List<Empresa>) MovdRepositorio.findAll();
    }


    public Optional<MovDinero> buscarEmpresa(String empresaId) {
        return MovdRepositorio.findById(empresaId);
    }
    public Optional<MovDinero> buscarEmpleado(String empleadoId) {
        return MovdRepositorio.findById(empleadoId);
    }

    public String agregarConcepto(MovDinero concepto){
        mdRepositorio.save(concepto);
        return"Agregar Consepto";


    }

        public String montoMovD (MovDinero movDinero){
            if (buscarMovd(movDinero.getId()).isPresent()) {
                MovdRepositorio.save(movDinero);
                return "Monto de dinero registrado";
            } else {
                return "Monto no valiodo";
            }

        }

        public String buscarEmpleado (Empleado empleado){
            if (!buscarMovd(empleado.getIdempleado()).isPresent()) {
               MovdRepositorio.save (new MovDinero());
                return "Nuevo empleado registrado";
            } else {
                return "El empleado no existe";
            }
        }

    }












