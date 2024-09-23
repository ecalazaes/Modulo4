package com.senac.johnny.gerenciamentosalas.repositories;

import com.senac.johnny.gerenciamentosalas.entities.RegistroUtilizacaoAmbiente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroUtilizacaoAmbienteRepository extends JpaRepository<RegistroUtilizacaoAmbiente, Integer> {
}
