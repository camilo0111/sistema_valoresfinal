package com.sistema_valores.service;

import com.sistema_valores.dto.ReporteConductor;
import com.sistema_valores.repository.ReporteConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteConductorService {

    @Autowired
    private ReporteConductorRepository repo;

    public List<ReporteConductor> obtenerReporte() {
        return repo.obtenerReporte();
    }
}
