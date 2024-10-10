package com.projeto04.Av1.services;

import com.projeto04.Av1.entities.AcompanhamentoPedido;
import com.projeto04.Av1.entities.enums.StatusPedido;
import com.projeto04.Av1.repositories.AcompanhamentoPedidoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AcompanhamentoPedidoService {

    private final AcompanhamentoPedidoRepository acompanhamentoPedidoRepository;

    public Map<Long, List<AcompanhamentoPedido>> obterTodosPedidos() {
        List<AcompanhamentoPedido> pedidos = acompanhamentoPedidoRepository.findByOrderByPedidoIdAscDataAtualizacaoDesc();
        return pedidos.stream().collect(Collectors.groupingBy(AcompanhamentoPedido::getPedidoId));
    }

    public List<AcompanhamentoPedido> obterHistoricoPorPedidoId(Long pedidoId) {
        return acompanhamentoPedidoRepository.findByPedidoIdOrderByDataAtualizacaoDesc(pedidoId);
    }

    @Transactional
    public AcompanhamentoPedido registrarAtualizacao(Long pedidoId, StatusPedido novoStatus) {
        AcompanhamentoPedido acompanhamento = new AcompanhamentoPedido(pedidoId, novoStatus);
        return acompanhamentoPedidoRepository.save(acompanhamento);
    }
}
