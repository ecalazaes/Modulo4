package com.senac.ecalazaes.VendasEletronico.repositories;

import com.senac.ecalazaes.VendasEletronico.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
