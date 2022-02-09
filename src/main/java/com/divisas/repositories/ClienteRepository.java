package com.divisas.repositories;
import com.divisas.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
  //  @Query(name="Cliente.findById")
   // Optional<Cliente> findById(Long id);
}
