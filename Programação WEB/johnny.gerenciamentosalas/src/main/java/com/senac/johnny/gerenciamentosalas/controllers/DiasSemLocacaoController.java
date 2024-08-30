package com.senac.johnny.gerenciamentosalas.controllers;

import com.senac.johnny.gerenciamentosalas.entities.Ambiente;
import com.senac.johnny.gerenciamentosalas.entities.DiasSemLocacao;
import com.senac.johnny.gerenciamentosalas.services.DiasSemLocacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dias")
public class DiasSemLocacaoController {

    private DiasSemLocacaoService diasSemLocacaoService;

    public DiasSemLocacaoController(DiasSemLocacaoService diasSemLocacaoService) {
        this.diasSemLocacaoService = diasSemLocacaoService;
    }

    @GetMapping
    public ResponseEntity<List<DiasSemLocacao>> listarDias(){
        List<DiasSemLocacao> dias = diasSemLocacaoService.listarDias();
        return ResponseEntity.ok(dias);
    }

    @PostMapping
    public ResponseEntity<DiasSemLocacao> saveDias(@RequestBody DiasSemLocacao diasSemLocacao) {
        DiasSemLocacao novoDias = diasSemLocacaoService.saveDias(diasSemLocacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiasSemLocacao> listarPorId(@PathVariable int id) {
        DiasSemLocacao diasSemLocacao = diasSemLocacaoService.listarPorId(id);
        return diasSemLocacao == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(diasSemLocacao);
    }


}
