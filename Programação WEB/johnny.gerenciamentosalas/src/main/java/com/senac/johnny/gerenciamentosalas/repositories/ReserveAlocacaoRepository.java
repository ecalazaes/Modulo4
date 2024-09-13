package com.senac.johnny.gerenciamentosalas.repositories;

import com.senac.johnny.gerenciamentosalas.entities.ReservaAlocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReserveAlocacaoRepository extends JpaRepository<ReservaAlocacao, Integer> {
}
