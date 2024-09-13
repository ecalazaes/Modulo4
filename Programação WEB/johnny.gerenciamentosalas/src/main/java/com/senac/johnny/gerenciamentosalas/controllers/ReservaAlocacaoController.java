package com.senac.johnny.gerenciamentosalas.controllers;

import com.senac.johnny.gerenciamentosalas.entities.ReservaAlocacao;
import com.senac.johnny.gerenciamentosalas.services.ReservaAlocacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaAlocacaoController {

    private ReservaAlocacaoService reservaAlocacaoService;

    public ReservaAlocacaoController(ReservaAlocacaoService reservaAlocacaoService) {
        this.reservaAlocacaoService = reservaAlocacaoService;
    }

    @GetMapping
    public ResponseEntity<List<ReservaAlocacao>> listarReservas(){
        List<ReservaAlocacao> reservas = reservaAlocacaoService.listarReservas();
        return ResponseEntity.ok(reservas);
    }
}
