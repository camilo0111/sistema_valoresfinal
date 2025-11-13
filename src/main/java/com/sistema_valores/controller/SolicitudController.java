package com.sistema_valores.controller;

import com.sistema_valores.model.Solicitud;
import com.sistema_valores.model.Solicitud.TipoSolicitud;
import com.sistema_valores.service.EntidadFinancieraService;
import com.sistema_valores.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;

@Controller
@RequestMapping("/secretario/solicitudes")
public class SolicitudController {

    @Autowired
    private SolicitudService service;

    @Autowired
    private EntidadFinancieraService entidadService;

    @GetMapping
    public String listarSolicitudes(Model model) {
        model.addAttribute("listaSolicitudes", service.listar());
        return "solicitudes/listar";
    }

    @GetMapping("/listar/{tipo}")
    public String listarPorTipo(
            @PathVariable("tipo") TipoSolicitud tipo,
            Model model) {
        model.addAttribute("listaSolicitudes", service.listarPorTipo(tipo));
        model.addAttribute("filtro", tipo);
        return "solicitudes/listar";
    }

    @GetMapping("/nueva")
    public String formularioNueva(Model model) {
        model.addAttribute("solicitud", new Solicitud());
        model.addAttribute("entidades", entidadService.listar());
        model.addAttribute("tipos", TipoSolicitud.values());
        return "solicitudes/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Solicitud solicitud, Model model) {
        try {
            service.guardar(solicitud);
            return "redirect:/secretario/solicitudes";
        } catch (DataIntegrityViolationException ex) {
            // Mensaje para el usuario
            model.addAttribute("error", "El código de solicitud ya existe. Intenta con uno diferente.");

            // Volvemos a cargar los selects
            model.addAttribute("entidades", entidadService.listar());
            model.addAttribute("tipos", Arrays.asList("Normal", "Urgente", "Programada"));
            model.addAttribute("solicitud", solicitud); // volver a mostrar los datos ingresados

            return "solicitudes/formulario"; // Asegúrate de que esta sea la vista correcta
        }
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("solicitud", service.obtenerPorId(id));
        model.addAttribute("entidades", entidadService.listar());
        model.addAttribute("tipos", TipoSolicitud.values());
        return "solicitudes/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/secretario/solicitudes";
    }
}
