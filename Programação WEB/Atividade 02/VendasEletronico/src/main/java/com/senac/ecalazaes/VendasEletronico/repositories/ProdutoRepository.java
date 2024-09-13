package com.senac.ecalazaes.VendasEletronico.repositories;

import com.senac.ecalazaes.VendasEletronico.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
