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

    @Transactional
    public AcompanhamentoPedido registrarAtualizacao(Long usuarioId, Long pedidoId, StatusPedido novoStatus) {
        AcompanhamentoPedido acompanhamento = new AcompanhamentoPedido(usuarioId, pedidoId, novoStatus);
        return acompanhamentoPedidoRepository.save(acompanhamento);
    }

    public Map<Long, Map<Long, List<AcompanhamentoPedido>>> obterPedidosPorUsuarioId(Long usuarioId) {
        List<AcompanhamentoPedido> pedidos = acompanhamentoPedidoRepository.findByUsuarioIdOrderByDataAtualizacaoDesc(usuarioId);

        return pedidos.stream()
                .collect(Collectors.groupingBy(AcompanhamentoPedido::getUsuarioId,
                        Collectors.groupingBy(AcompanhamentoPedido::getPedidoId)));
    }


}
