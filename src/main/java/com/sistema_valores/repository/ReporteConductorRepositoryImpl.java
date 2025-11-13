package com.sistema_valores.repository;

import com.sistema_valores.dto.ReporteConductor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReporteConductorRepositoryImpl implements ReporteConductorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ReporteConductor> obtenerReporte() {
        return em.createQuery(
                "SELECT new com.sistema_valores.dto.ReporteConductor(" +
                        "s.codigo, " +
                        "s.nitEntidad, " +
                        "e.nombre, " +
                        "CAST(s.fechaSolicitud AS string), " +
                        "CAST(s.fechaRealizado AS string), " +
                        "CAST(s.valor AS string), " +
                        "e.direccion) " +
                        "FROM Solicitud s " +
                        "JOIN EntidadFinanciera e ON s.nitEntidad = e.nit ",
                ReporteConductor.class).getResultList();
    }
}
