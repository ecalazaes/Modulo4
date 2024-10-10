package com.projeto04.Av1.controllers;

import com.projeto04.Av1.entities.AcompanhamentoPedido;
import com.projeto04.Av1.entities.enums.StatusPedido;
import com.projeto04.Av1.services.AcompanhamentoPedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("acompanhamento")
@RequiredArgsConstructor
public class AcompanhamentoPedidoController {

    private final AcompanhamentoPedidoService acompanhamentoService;


    @GetMapping("pedidos")
    public ResponseEntity<Map<Long, List<AcompanhamentoPedido>>> obterTodosPedidos() {
        Map<Long, List<AcompanhamentoPedido>> todosPedidos = acompanhamentoService.obterTodosPedidos();
        return ResponseEntity.ok(todosPedidos);
    }

    @GetMapping("/{pedidoId}/historico")
    public ResponseEntity<List<AcompanhamentoPedido>> obterHistorico(@PathVariable Long pedidoId) {
        List<AcompanhamentoPedido> historico = acompanhamentoService.obterHistoricoPorPedidoId(pedidoId);
        return ResponseEntity.ok(historico);
    }

    @PostMapping("/{pedidoId}/atualizar")
    public ResponseEntity<AcompanhamentoPedido> atualizarStatus(@PathVariable Long pedidoId, @RequestParam StatusPedido status) {
        AcompanhamentoPedido acompanhamento = acompanhamentoService.registrarAtualizacao(pedidoId, status);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
