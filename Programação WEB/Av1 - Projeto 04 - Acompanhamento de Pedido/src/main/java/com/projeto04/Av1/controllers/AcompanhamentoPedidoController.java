package com.projeto04.Av1.controllers;

import com.projeto04.Av1.entities.AcompanhamentoPedido;
import com.projeto04.Av1.entities.CarrinhoDTO;
import com.projeto04.Av1.entities.Usuario;
import com.projeto04.Av1.entities.enums.StatusPedido;
import com.projeto04.Av1.interfacefeign.CarrinhoFeignClient;
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

    @GetMapping("/carrinho/{idCarrinho}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<CarrinhoDTO> obterCarrinho(@PathVariable int idCarrinho) {
        return ResponseEntity.ok(acompanhamentoService.obterCarrinho(idCarrinho));
    }

    @GetMapping("/usuario/{usuarioId}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Usuario> obterUsuario(@PathVariable int usuarioId) {
        return ResponseEntity.ok(acompanhamentoService.obterUsuario(usuarioId));
    }

    @GetMapping("pedidos")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Map<Long, List<AcompanhamentoPedido>>> obterTodosPedidos() {
        Map<Long, List<AcompanhamentoPedido>> todosPedidos = acompanhamentoService.obterTodosPedidos();
        return ResponseEntity.ok(todosPedidos);
    }

    @GetMapping("/{pedidoId}/historico")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<AcompanhamentoPedido>> obterHistorico(@PathVariable Long pedidoId) {
        List<AcompanhamentoPedido> historico = acompanhamentoService.obterHistoricoPorPedidoId(pedidoId);
        return ResponseEntity.ok(historico);
    }

    @PostMapping("/{usuarioId}/{pedidoId}/atualizar")
    @CrossOrigin(origins = "*")
    public ResponseEntity<AcompanhamentoPedido> atualizarStatus(@PathVariable Long usuarioId, @PathVariable Long pedidoId, @RequestParam StatusPedido status) {
        AcompanhamentoPedido acompanhamento = acompanhamentoService.registrarAtualizacao(usuarioId, pedidoId, status);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
