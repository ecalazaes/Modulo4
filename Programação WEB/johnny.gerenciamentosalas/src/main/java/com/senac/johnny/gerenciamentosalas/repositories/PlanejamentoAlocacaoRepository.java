package com.senac.johnny.gerenciamentosalas.repositories;

import com.senac.johnny.gerenciamentosalas.entities.PlanejamentoAlocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanejamentoAlocacaoRepository extends JpaRepository<PlanejamentoAlocacao, Integer> {
}
