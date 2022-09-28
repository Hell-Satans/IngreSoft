package com.UdeA.IngreSoft.Controlador;

import com.UdeA.IngreSoft.Entidad.Empresa;
import com.UdeA.IngreSoft.Servicios.EmpresaServicios;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class VistaEmpresasControlador {
    EmpresaServicios empresaServicio;
    //empleadoServicio servicio;

    public VistaEmpresasControlador(EmpresaServicios empresaServicio) {
        this.empresaServicio = empresaServicio;
    }

    @GetMapping("/Empresas")
    public String prueba(Model model){
        List<Empresa> lista=this.empresaServicio.listarEmpresas();
        model.addAttribute("lista",lista);
        return "Empresas";
    }
    @GetMapping("/formEmpresa")
    public String mostrarFormulario(Model model){
        model.addAttribute("empresa",new Empresa());
        return "registrarEmpresa";
    }

    @PostMapping("/RegistrarEmpresa")
    public String agregarEmpresa(@ModelAttribute("empresa") Empresa empresa, Model model, RedirectAttributes attributes){
        if(empresaServicio.saveEmpresa(empresa)) {
            attributes.addFlashAttribute("mensajeOk","Empresa registrada exitosamente.");
        }else{
            attributes.addFlashAttribute("error","Error, la empresa no se registro.");
        }
        return "redirect:/Empresas";
    }

    @GetMapping("/editarEmpresa/{id}")
    public String pasarLibro(@PathVariable("id") int id, Model model){
        model.addAttribute("empresa", empresaServicio.buscarEmpresa(id));
        return "editarEmpresa";
    }
    @GetMapping("/perfilEmpresa/{id}")
    public String pasarEmpresa(@PathVariable("id") int id, Model model){
        model.addAttribute("empresa", empresaServicio.buscarEmpresa(id));
        return "PerfilEmpresa";
    }

    @GetMapping("/eliminarEmpresa/{id}")
    public String eliminarLibro(@PathVariable("id") int id,Model model,RedirectAttributes attributes){
        if(empresaServicio.eliminarEmpresa(id)){
            attributes.addFlashAttribute("borrarOk","Empresa eliminada exitosamente.");
        }else{
            attributes.addFlashAttribute("borrarError","Error, la empresa no se eliminó.");
        }
        return "redirect:/Empresas";
    }

    @PostMapping("/guardarEditado/{id}")
    public String actualizarLibro(@PathVariable("id") int id, @ModelAttribute("empresa") Empresa empresa,Model model,RedirectAttributes attributes){
        Empresa emp=empresaServicio.buscarEmpresa(id);
        emp.setNombre(empresa.getNombre());
        emp.setDireccion(empresa.getDireccion());
        emp.setTelefono(empresa.getTelefono());
        emp.setNit(empresa.getNit());
        if(empresaServicio.saveEmpresa(emp)){
            attributes.addFlashAttribute("Ok","Empresa actualizada exitosamente.");
        }else{
            attributes.addFlashAttribute("Error","Error, la empresa no se actualizó.");
        }
        return "redirect:/Empresas";
    }
}
