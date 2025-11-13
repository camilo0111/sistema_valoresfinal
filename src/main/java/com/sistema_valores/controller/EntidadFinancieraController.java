package com.sistema_valores.controller;

import com.sistema_valores.model.EntidadFinanciera;
import com.sistema_valores.service.EntidadFinancieraService;
import com.sistema_valores.service.MovimientoService;
import com.sistema_valores.service.SolicitudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/entidades")
public class EntidadFinancieraController {

    @Autowired
    private EntidadFinancieraService service;

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private MovimientoService movimientoService;

    @GetMapping
    public String listarEntidades(Model model) {
        model.addAttribute("listaEntidades", service.listar());
        return "entidades/listar";
    }

    @GetMapping("/nueva")
    public String formularioNuevaEntidad(Model model) {
        model.addAttribute("entidad", new EntidadFinanciera());
        return "entidades/formulario";
    }

    @PostMapping("/guardar")
    public String guardarEntidad(@ModelAttribute EntidadFinanciera entidad, Model model) {
        try {
            service.guardar(entidad);
            return "redirect:/admin/entidades";
        } catch (Exception e) {
            // Verifica si es por duplicado
            if (e.getCause() != null
                    && e.getCause().getCause() instanceof java.sql.SQLIntegrityConstraintViolationException) {
                model.addAttribute("error", "Ya existe una entidad con ese NIT.");
            } else {
                model.addAttribute("error", "Error al guardar la entidad.");
            }

            // Reenvía el formulario con el mensaje de error
            model.addAttribute("entidad", entidad);
            return "entidades/formulario";
        }
    }

    @GetMapping("/editar/{id}")
    public String editarEntidad(@PathVariable Long id, Model model) {
        model.addAttribute("entidad", service.obtenerPorId(id));
        return "entidades/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEntidad(@PathVariable Long id) {
        EntidadFinanciera entidad = service.obtenerPorId(id);
        String nit = entidad.getNit(); // ⚠️ Asegúrate de que getNit() esté definido

        movimientoService.eliminarPorNitEntidad(nit);
        solicitudService.eliminarPorNitEntidad(nit);

        service.eliminar(id);

        return "redirect:/admin/entidades";
    }

}
