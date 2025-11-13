package com.sistema_valores.repository;

import com.sistema_valores.model.EntidadFinanciera;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EntidadFinancieraRepository extends JpaRepository<EntidadFinanciera, Long> {
    Optional<EntidadFinanciera> findByNit(String nit);
}
