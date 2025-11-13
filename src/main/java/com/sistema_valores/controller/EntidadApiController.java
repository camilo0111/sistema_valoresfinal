package com.sistema_valores.controller;

import com.sistema_valores.model.EntidadFinanciera;
import com.sistema_valores.service.MovimientoService;
import com.sistema_valores.service.EntidadFinancieraService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entidades")
@CrossOrigin
public class EntidadApiController {

    private final EntidadFinancieraService service;

    public EntidadApiController(EntidadFinancieraService service, MovimientoService movimientoService) {
        this.service = service;
    }

    @GetMapping
    public List<EntidadFinanciera> all() {
        return service.listar();
    }

    @GetMapping("/{nit}")
    public EntidadFinanciera byNit(@PathVariable String nit) {
        return service.obtenerPorNit(nit);
    }

}
