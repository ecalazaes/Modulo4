package com.senac.ecalazaes.VendasEletronico.repositories;

import com.senac.ecalazaes.VendasEletronico.entities.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
}
