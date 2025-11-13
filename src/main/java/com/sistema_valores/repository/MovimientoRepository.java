package com.sistema_valores.repository;

import com.sistema_valores.model.Movimiento;
import com.sistema_valores.model.Movimiento.TipoMovimiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    List<Movimiento> findByNitEntidad(String nitEntidad);

    List<Movimiento> findByNitEntidadAndTipoMovimiento(String nitEntidad, TipoMovimiento tipoMovimiento);

    @Modifying
    @Query("DELETE FROM Movimiento m WHERE m.nitEntidad = :nit")
    void deleteByNitEntidad(@Param("nit") String nit);

}
