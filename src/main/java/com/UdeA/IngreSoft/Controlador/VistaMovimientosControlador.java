package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Entidad.MovDinero;
import com.UdeA.IngreSoft.Servicios.EmpresaServicios;
import com.UdeA.IngreSoft.Servicios.ServiciosMovD;
import com.UdeA.IngreSoft.Servicios.empleadoServicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class VistaMovimientosControlador {

    ServiciosMovD servicioMovimientos;
    empleadoServicio empleadoServicio;
    EmpresaServicios empresaServicios;

    public VistaMovimientosControlador(ServiciosMovD servicioMovimientos, com.UdeA.IngreSoft.Servicios.empleadoServicio empleadoServicio, EmpresaServicios empresaServicios) {
        this.servicioMovimientos = servicioMovimientos;
        this.empleadoServicio = empleadoServicio;
        this.empresaServicios = empresaServicios;
    }

    @GetMapping("/Movimientos")
    public String prueba(Model model){
        List<MovDinero> lista=this.servicioMovimientos.listarMovimientos();
        model.addAttribute("movlist",lista);
        Long sumaMonto=servicioMovimientos.obtenerSumaMontos();
        model.addAttribute("SumaMontos",sumaMonto);
        return "Movimientos";
    }
    @GetMapping("/formMovimiento")
    public String mostrarFormulario(Model model){
        model.addAttribute("movimiento",new MovDinero());
        List<Empleado> listaEmpleados= this.empleadoServicio.listaEmpleados();
        model.addAttribute("empleadolist",listaEmpleados);
        return "registrarMovimientos";
    }
    @GetMapping("/formMov/{idem}")
    public String mostrarFormulario2(@PathVariable("idem")int idem, Model model){
        model.addAttribute("empleado", empleadoServicio.buscarEmpleado2(idem));
        model.addAttribute("transaccion",new MovDinero());
        Empresa listaEmpresa= this.empresaServicios.empresaEmpleado(idem);
        model.addAttribute("emprelist",listaEmpresa);
        return "agregarMovimientosEmpleado";
    }
    /*@PostMapping("/agregarMovimiento/{id}/{idem}")
    public String agregarEmpleadosEm(@PathVariable("id") int id,@PathVariable("idem")int idem,@ModelAttribute("movimiento") MovDinero mov, Model model, RedirectAttributes attributes){
        if(servicioMovimientos.agregarMovimiento(id,idem,mov)){
            attributes.addFlashAttribute("mensajeOk","Transacción registrada exitosamente.");
        }else{
            attributes.addFlashAttribute("error","Error, la transacción no se registro.");
        }
        return "redirect:/Empleados";
    }*/
    @PostMapping("/agregarMovimiento/{idem}")
    public String agregarMovimientos(@PathVariable("idem")int idem,@ModelAttribute("movimiento") MovDinero movimiento, Model model, RedirectAttributes attributes){
        if(servicioMovimientos.agregarMovi(idem,movimiento)){
            attributes.addFlashAttribute("mensajeOk","Transacción registrada exitosamente.");
        }else{
            attributes.addFlashAttribute("error","Error, la transacción no se registro.");
        }
        return "redirect:/Movimientos";
    }
    @PostMapping("/RegistrarMovimiento")
    public String agregarMovimiento(@ModelAttribute("movimiento") MovDinero movimiento, Model model, RedirectAttributes attributes){
        //model.addAttribute("empleado", empleado);
        if(servicioMovimientos.agregarMov(movimiento)){
            attributes.addFlashAttribute("mensajeOk","Empleado registrado exitosamente.");
        }else{
            attributes.addFlashAttribute("error","Error, el empleado no se registro.");
        }
        return "redirect:/Empleados";
    }

    @GetMapping("/editarMovimiento/{id}")
    public String pasarMovimiento(@PathVariable("id") int id, Model model){
        model.addAttribute("transaccion", servicioMovimientos.buscarMov(id));
        List<Empleado> listaEmpleados= empleadoServicio.listaEmpleados();
        model.addAttribute("emplelist",listaEmpleados);
        return "editarMovimiento";
    }
    @GetMapping("/eliminarMovimiento/{id}")
    public String eliminarMovimiento(@PathVariable("id") int id,Model model){
        servicioMovimientos.eliminarMovimiento(id);
        return "redirect:/Movimientos";
    }

    @PostMapping("/guardarMovimiento/{id}")
    public String actualizarMovimiento(@PathVariable("id") int id, @ModelAttribute("transaccion") MovDinero movDinero,Model model){
        MovDinero mov=servicioMovimientos.buscarMov(id);
        mov.setMonto(movDinero.getMonto());
        mov.setConcepto(movDinero.getConcepto());
        mov.setEmpleado(movDinero.getEmpleado());
        mov.setFecha(movDinero.getFecha());
        servicioMovimientos.agregarMov(mov);
        return "redirect:/Movimientos";
    }
    @GetMapping("/Empleado/{id}/Movimientos")
    public String movimientosPorEmpleado(@PathVariable("id")Integer id, Model model){
        List<MovDinero> movlist = servicioMovimientos.movimientosPorEmpleado(id);
        model.addAttribute("movlist",movlist);
        Long sumaMonto=servicioMovimientos.MontosPorEmpleado(id);
        model.addAttribute("SumaMontos",sumaMonto);
        return "Movimientos";
    }

    @GetMapping("/Empresa/{id}/Movimientos")
    public String movimientosPorEmpresa(@PathVariable("id")Integer id, Model model){
        List<MovDinero> movlist = servicioMovimientos.movimientosPorEmpresa(id);
        model.addAttribute("movlist",movlist);
        Long sumaMonto=servicioMovimientos.MontosPorEmpresa(id);
        model.addAttribute("SumaMontos",sumaMonto);
        return "Movimientos";
    }
}
