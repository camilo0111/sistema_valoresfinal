package com.sistema_valores.service;

import com.sistema_valores.model.Solicitud;
import com.sistema_valores.model.Solicitud.TipoSolicitud;
import com.sistema_valores.repository.MovimientoRepository;
import com.sistema_valores.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository repo;

    public List<Solicitud> listar() {
        return repo.findAll();
    }

    public java.util.List<String> listarConductores() {
        return repo.findDistinctNombreConductor();
    }

    public void guardar(Solicitud solicitud) {
        repo.save(solicitud);
    }

    public Solicitud obtenerPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Solicitud> listarPorTipo(TipoSolicitud tipo) {
        return repo.findByTipoSolicitud(tipo);
    }

    @Transactional
    public void eliminarPorNitEntidad(String nit) {
        repo.deleteByNitEntidad(nit);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
