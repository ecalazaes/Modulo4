package com.senac.johnny.gerenciamentosalas.repositories;

import com.senac.johnny.gerenciamentosalas.entities.Ambiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbienteRepository extends JpaRepository<Ambiente, Integer> {
}
