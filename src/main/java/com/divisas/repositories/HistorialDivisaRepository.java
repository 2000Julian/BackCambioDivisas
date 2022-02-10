package com.divisas.repositories;

import com.divisas.entities.HistorialDivisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialDivisaRepository extends JpaRepository<HistorialDivisa, Long> {
}
