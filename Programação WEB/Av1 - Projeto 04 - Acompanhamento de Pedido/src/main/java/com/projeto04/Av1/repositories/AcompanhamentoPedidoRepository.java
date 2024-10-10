package com.projeto04.Av1.repositories;

import com.projeto04.Av1.entities.AcompanhamentoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AcompanhamentoPedidoRepository extends JpaRepository<AcompanhamentoPedido, Long> {

    List<AcompanhamentoPedido> findByPedidoIdOrderByDataAtualizacaoDesc(long pedidoId);

    List<AcompanhamentoPedido> findByOrderByPedidoIdAscDataAtualizacaoDesc();

}
