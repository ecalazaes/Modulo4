package com.projeto04.Av1.services;

import com.projeto04.Av1.dto.AcompanhamentoPedidoDTO;
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
        boolean usuarioTemPedidoId = acompanhamentoPedidoRepository.existsByUsuarioIdAndPedidoId(usuarioId, pedidoId);
        boolean pedidoIdNaoExiste = !acompanhamentoPedidoRepository.existsByPedidoId(pedidoId);


        if (usuarioTemPedidoId || pedidoIdNaoExiste) {
            AcompanhamentoPedido acompanhamento = new AcompanhamentoPedido(usuarioId, pedidoId, novoStatus);
            return acompanhamentoPedidoRepository.save(acompanhamento);
        }
        throw new IllegalArgumentException("O usuário não possui autorização para atualizar este pedido.");
    }

    public Map<Long, Map<Long, List<AcompanhamentoPedidoDTO>>> obterPedidosPorUsuarioId(Long usuarioId) {
        List<AcompanhamentoPedido> pedidos = acompanhamentoPedidoRepository.findByUsuarioIdOrderByDataAtualizacaoDesc(usuarioId);

        return pedidos.stream()
                .collect(Collectors.groupingBy(
                        AcompanhamentoPedido::getUsuarioId,
                        Collectors.groupingBy(
                                AcompanhamentoPedido::getPedidoId,
                                Collectors.mapping(this::toDTO, Collectors.toList())
                        )
                ));
    }

    // Método auxiliar para converter AcompanhamentoPedido em AcompanhamentoPedidoDTO
    private AcompanhamentoPedidoDTO toDTO(AcompanhamentoPedido acompanhamentoPedido) {
        return new AcompanhamentoPedidoDTO(
                acompanhamentoPedido.getStatus(),
                acompanhamentoPedido.getDataAtualizacao()
        );
    }
}
