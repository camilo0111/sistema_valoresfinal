package com.sistema_valores.controller;

import com.sistema_valores.model.Movimiento;
import com.sistema_valores.service.MovimientoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/entidades/{nit}/movimientos")
@CrossOrigin
public class MovimientoApiController {

    private final MovimientoService service;

    public MovimientoApiController(MovimientoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Movimiento> obtenerMovimientos(
            @PathVariable String nit,
            @RequestParam(required = false) String tipo) {
        return service.listarPorNitYTipo(nit, tipo);
    }

}
