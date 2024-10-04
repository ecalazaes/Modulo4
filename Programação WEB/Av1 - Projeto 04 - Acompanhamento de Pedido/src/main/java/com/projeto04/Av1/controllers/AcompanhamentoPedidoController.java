package com.projeto04.Av1.controllers;

import com.projeto04.Av1.entities.AcompanhamentoPedido;
import com.projeto04.Av1.entities.StatusPedido;
import com.projeto04.Av1.services.AcompanhamentoPedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("acompanhamento")
public class AcompanhamentoPedidoController {

    private AcompanhamentoPedidoService acompanhamentoService;

    public AcompanhamentoPedidoController(AcompanhamentoPedidoService acompanhamentoService) {
        this.acompanhamentoService = acompanhamentoService;
    }

    @PostMapping("/{pedidoId}/atualizar")
    public ResponseEntity<AcompanhamentoPedido> atualizarStatus(@PathVariable Long pedidoId, @RequestParam StatusPedido status){
        AcompanhamentoPedido acompanhamento = acompanhamentoService.registrarAtualizacao(pedidoId, status);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{pedidoId}/historico")
    public ResponseEntity<List<AcompanhamentoPedido>> obterHistorico(@PathVariable Long pedidoId){
        List<AcompanhamentoPedido> historico = acompanhamentoService.obterHistoricoPorPedidoId(pedidoId);
        return ResponseEntity.ok(historico);
    }
}
