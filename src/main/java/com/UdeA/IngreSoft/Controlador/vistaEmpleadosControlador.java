package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.Empleado;
import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Entidad.Perfil;
import com.UdeA.IngreSoft.Servicios.EmpresaServicios;
import com.UdeA.IngreSoft.Servicios.empleadoServicio;
import com.UdeA.IngreSoft.Servicios.perfilServicios;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class vistaEmpleadosControlador {
    empleadoServicio servicio;
    EmpresaServicios empresaServicios;
    perfilServicios perfilServicio;


    public vistaEmpleadosControlador(empleadoServicio servicio, EmpresaServicios empresaServicios, perfilServicios perfilServicio) {
        this.servicio = servicio;
        this.empresaServicios = empresaServicios;
        this.perfilServicio = perfilServicio;
    }

    @GetMapping("/")
    public String index(Model model, @AuthenticationPrincipal OidcUser principal){
        if(principal !=null){
            Perfil user=perfilServicio.comprobarUsuario(principal.getClaims());

            model.addAttribute("user",user);
            //System.out.println(principal.getClaims());
        }
        return "index";
    }

    @GetMapping("/Empleados")
    public String prueba(Model model){
        List<Empleado> lista=this.servicio.listaEmpleados();
        model.addAttribute("lista",lista);
        return "Empleados";
    }
    @GetMapping("/formEmpleado")
    public String mostrarFormulario(Model model){
        model.addAttribute("empleado",new Empleado());
        List<Empresa> listaEmpresas= this.empresaServicios.listarEmpresas();
        model.addAttribute("emprelist",listaEmpresas);
        return "registrarEmpleados";
    }
    @GetMapping("/formEmpleado/{id}")
    public String mostrarFormulario2(@PathVariable("id") int id, Model model){
        model.addAttribute("empresa", empresaServicios.buscarEmpresa(id));
        model.addAttribute("empleado",new Empleado());
        //List<Empresa> listaEmpresas= this.empresaServicios.listarEmpresas();
        //model.addAttribute("emprelist",listaEmpresas);
        return "agregarEmpleadosEm";
    }

    @GetMapping("/Empresa/{id}/Empleados")
    public String mostrarPorEmpresa(@PathVariable("id")int id,Model model){
        List<Empleado> listaEmpleados = servicio.empleadosEmpresa(id);
        model.addAttribute("lista",listaEmpleados);
        return "Empleados";
    }
    @PostMapping("/RegistrarEmpleado")
    public String agregarEmpleados(@ModelAttribute("empleado") Empleado empleado, Model model, RedirectAttributes attributes){
        //model.addAttribute("empleado", empleado);
        if(servicio.agregarEmpleado(empleado)){
            attributes.addFlashAttribute("mensajeOk","Empleado registrado exitosamente.");
        }else{
            attributes.addFlashAttribute("error","Error, el empleado no se registro.");
        }
        return "redirect:/Empleados";
    }
    @PostMapping("/agregarEmpleado/{id}")
    public String agregarEmpleadosEm(@PathVariable("id") int id,@ModelAttribute("empleado") Empleado empleado, Model model, RedirectAttributes attributes){
        //model.addAttribute("empleado", empleado);
        if(servicio.agregarEmpleador(id,empleado)){
            attributes.addFlashAttribute("mensajeOk","Empleado registrado exitosamente.");
        }else{
            attributes.addFlashAttribute("error","Error, el empleado no se registro.");
        }
        return "redirect:/Empleados";
    }

    @GetMapping("/editarEmpleado/{id}")
    public String pasarEmpleado(@PathVariable("id") int idempleado, Model model){
        model.addAttribute("empleado", servicio.buscarEmpleado2(idempleado));
        List<Empresa> listaEmpresas= this.empresaServicios.listarEmpresas();
        model.addAttribute("emprelist",listaEmpresas);
        return "editarEmpleados";
    }
    @GetMapping("/eliminarEmpleado/{id}")
    public String eliminarEmpleado(@PathVariable("id") int id,Model model){
        servicio.eliminarEmpleado(id);
        return "redirect:/Empleados";
    }

    @PostMapping("/guardarEmpleadoEdit/{id}")
    public String actualizarLibro(@PathVariable("id") int id, @ModelAttribute("empleado") Empleado empleado,Model model){
        Empleado emple=servicio.buscarEmpleado2(id);
        emple.setNombre(empleado.getNombre());
        emple.setTelefono(empleado.getTelefono());
        emple.setCorreo(empleado.getCorreo());
        emple.setEmpresa(empleado.getEmpresa());
        servicio.agregarEmpleado(emple);
        return "redirect:/Empleados";
    }
}
