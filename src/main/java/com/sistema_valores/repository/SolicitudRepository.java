package com.sistema_valores.repository;

import com.sistema_valores.model.Solicitud;
import com.sistema_valores.model.Solicitud.TipoSolicitud;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
    List<Solicitud> findByTipoSolicitud(TipoSolicitud tipoSolicitud);

    @Modifying
    @Query("DELETE FROM Solicitud s WHERE s.nitEntidad = :nit")
    void deleteByNitEntidad(@Param("nit") String nit);

    @Query("SELECT DISTINCT s.nombreConductor FROM Solicitud s WHERE s.nombreConductor IS NOT NULL AND s.nombreConductor <> ''")
    java.util.List<String> findDistinctNombreConductor();

}
