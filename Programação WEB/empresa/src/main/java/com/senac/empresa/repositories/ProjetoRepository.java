package com.senac.empresa.repositories;

import com.senac.empresa.entities.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository <Projeto, Integer> {
    @Query("SELECT a from Projeto a WHERE a.status != -1")
    List<Projeto> getProjetosAtivos();
}
