package com.UdeA.IngreSoft.Servicios;


import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Entidad.MovDinero;
import com.UdeA.IngreSoft.Repositorio.RepositorioMovD;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ServiciosMovD {
    private RepositorioMovD MovdRepositorio;


    public ServiciosMovD(RepositorioMovD MovdRepositorio) {

        this.MovdRepositorio = MovdRepositorio;
    }



    public List<MovDinero> movimientosDineroEmpresa(int id) {
        return  MovdRepositorio.findByEmpresaId(id);
    }

    public MovDinero agregarMovimientoDinero(int id, MovDinero movimientoDinero) {
    Empresa empresa = new Empresa();
    empresa.setId(id);
    movimientoDinero.setEmpresa(empresa);
    return MovdRepositorio.save(movimientoDinero);

    }

    

    public MovDinero actualizarMovDinero(int id) {
        Empresa empresa = new Empresa();
        empresa.setId(id);
        MovDinero movimientoDinero = null;
        movimientoDinero.setEmpresa(empresa);
        return MovdRepositorio.save(movimientoDinero);
    }
}














