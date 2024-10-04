package com.projeto04.Av1.services;

import com.projeto04.Av1.entities.AcompanhamentoPedido;
import com.projeto04.Av1.entities.StatusPedido;
import com.projeto04.Av1.repositories.AcompanhamentoPedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcompanhamentoPedidoService {

    private AcompanhamentoPedidoRepository repository;

    public AcompanhamentoPedidoService(AcompanhamentoPedidoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public AcompanhamentoPedido registrarAtualizacao(Long pedidoId, StatusPedido novoStatus) {
        AcompanhamentoPedido acompanhamento = new AcompanhamentoPedido(pedidoId, novoStatus);
        return repository.save(acompanhamento);
    }

    public List<AcompanhamentoPedido> obterHistoricoPorPedidoId(Long pedidoId) {
        return repository.findByPedidoIdOrderByDataAtualizacaoDesc(pedidoId);
    }
}
