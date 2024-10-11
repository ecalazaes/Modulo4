package com.projeto04.Av1.services;

import com.projeto04.Av1.entities.AcompanhamentoPedido;
import com.projeto04.Av1.entities.CarrinhoDTO;
import com.projeto04.Av1.entities.Usuario;
import com.projeto04.Av1.entities.enums.StatusPedido;
import com.projeto04.Av1.interfacefeign.CarrinhoFeignClient;
import com.projeto04.Av1.interfacefeign.UsuarioFeignClient;
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
    private final CarrinhoFeignClient carrinhoFeignClient;
    private final UsuarioFeignClient usuarioFeignClient;

    public Usuario obterUsuario(int usuarioId) {
        return usuarioFeignClient.findById(usuarioId).getBody();
    }

    public CarrinhoDTO obterCarrinho(int carrinhoId) {
        return carrinhoFeignClient.findById(carrinhoId).getBody();
    }

//    public Map<Long, List<AcompanhamentoPedido>> obterTodosPedidos() {
//        List<AcompanhamentoPedido> pedidos = acompanhamentoPedidoRepository.findByOrderByPedidoIdAscDataAtualizacaoDesc();
//        return pedidos.stream().collect(Collectors.groupingBy(AcompanhamentoPedido::getPedidoId));
//    }

//    public Map<Long, List<Long>> obterTodosPedidos() {
//        List<AcompanhamentoPedido> pedidos = acompanhamentoPedidoRepository.findByOrderByPedidoIdAscDataAtualizacaoDesc();
//
//        return pedidos.stream()
//                .collect(Collectors.groupingBy(
//                        AcompanhamentoPedido::getUsuarioId,
//                        Collectors.mapping(AcompanhamentoPedido::getPedidoId, Collectors.toList())
//                ));
//    }

    public Map<Long, List<AcompanhamentoPedido>> obterTodosPedidos() {
        List<AcompanhamentoPedido> pedidos = acompanhamentoPedidoRepository.findByOrderByPedidoIdAscDataAtualizacaoDesc();

        return pedidos.stream()
                .collect(Collectors.groupingBy(AcompanhamentoPedido::getUsuarioId));
    }


    public List<AcompanhamentoPedido> obterHistoricoPorPedidoId(Long pedidoId) {
        return acompanhamentoPedidoRepository.findByPedidoIdOrderByDataAtualizacaoDesc(pedidoId);
    }

    @Transactional
    public AcompanhamentoPedido registrarAtualizacao(Long usuarioId, Long pedidoId, StatusPedido novoStatus) {
        AcompanhamentoPedido acompanhamento = new AcompanhamentoPedido(usuarioId, pedidoId, novoStatus);
        return acompanhamentoPedidoRepository.save(acompanhamento);
    }
}
