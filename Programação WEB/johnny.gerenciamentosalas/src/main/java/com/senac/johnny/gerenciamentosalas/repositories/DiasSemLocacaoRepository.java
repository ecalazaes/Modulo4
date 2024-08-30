package com.senac.johnny.gerenciamentosalas.repositories;

import com.senac.johnny.gerenciamentosalas.entities.DiasSemLocacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiasSemLocacaoRepository extends JpaRepository<DiasSemLocacao, Integer> {
}
