package com.sistema_valores.service;

import com.sistema_valores.model.EntidadFinanciera;
import com.sistema_valores.repository.EntidadFinancieraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntidadFinancieraService {

    @Autowired
    private EntidadFinancieraRepository repo;

    public List<EntidadFinanciera> listar() {
        return repo.findAll();
    }

    public void guardar(EntidadFinanciera entidad) {
        repo.save(entidad);
    }

    public EntidadFinanciera obtenerPorId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public EntidadFinanciera obtenerPorNit(String nit) {
        return repo.findByNit(nit).orElse(null);
    }
}
