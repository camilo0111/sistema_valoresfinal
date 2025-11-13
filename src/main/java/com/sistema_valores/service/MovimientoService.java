package com.sistema_valores.service;

import com.sistema_valores.model.Movimiento;
import com.sistema_valores.model.Movimiento.TipoMovimiento;
import com.sistema_valores.repository.MovimientoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MovimientoService {

    private final MovimientoRepository repo;

    public MovimientoService(MovimientoRepository repo) {
        this.repo = repo;
    }

    public List<Movimiento> listarPorNitYTipo(String nit, String tipo) {
        if (tipo == null || tipo.isBlank()) {
            return repo.findByNitEntidad(nit);
        }
        TipoMovimiento tm = TipoMovimiento.valueOf(tipo.toUpperCase());
        return repo.findByNitEntidadAndTipoMovimiento(nit, tm);
    }

    @Transactional
    public void eliminarPorNitEntidad(String nit) {
        repo.deleteByNitEntidad(nit);
    }
}
