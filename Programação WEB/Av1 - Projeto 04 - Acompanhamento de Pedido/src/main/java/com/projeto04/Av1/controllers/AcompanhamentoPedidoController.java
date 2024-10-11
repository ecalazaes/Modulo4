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

    @GetMapping("/{usuarioId}/pedidos")
    public ResponseEntity<Map<Long, Map<Long, List<AcompanhamentoPedido>>>> obterPedidosPorUsuarioId(@PathVariable Long usuarioId) {
        Map<Long, Map<Long, List<AcompanhamentoPedido>>> pedidos = acompanhamentoService.obterPedidosPorUsuarioId(usuarioId);
        return ResponseEntity.ok(pedidos);
    }

    @PostMapping("/{usuarioId}/{pedidoId}/atualizar")
    @CrossOrigin(origins = "*")
    public ResponseEntity<AcompanhamentoPedido> atualizarStatus(@PathVariable Long usuarioId, @PathVariable Long pedidoId, @RequestParam StatusPedido status) {
        AcompanhamentoPedido acompanhamento = acompanhamentoService.registrarAtualizacao(usuarioId, pedidoId, status);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
