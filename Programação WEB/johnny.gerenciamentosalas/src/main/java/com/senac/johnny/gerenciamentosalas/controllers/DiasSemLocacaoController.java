package com.senac.johnny.gerenciamentosalas.controllers;

import com.senac.johnny.gerenciamentosalas.entities.DiasSemLocacao;
import com.senac.johnny.gerenciamentosalas.entities.Usuario;
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

    @GetMapping("listar")
    public ResponseEntity<List<DiasSemLocacao>> listarDias(){
        List<DiasSemLocacao> dias = diasSemLocacaoService.listarDias();
        return ResponseEntity.ok(dias);
    }

    @PostMapping("criar")
    public ResponseEntity<DiasSemLocacao> saveDias(@RequestBody DiasSemLocacao diasSemLocacao) {
        DiasSemLocacao novoDia = diasSemLocacaoService.saveDias(diasSemLocacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDia);
    }

    @GetMapping("listarPorId/{id}")
    public ResponseEntity<DiasSemLocacao> listarPorId(@PathVariable int id) {
        DiasSemLocacao diasSemLocacao = diasSemLocacaoService.listarPorId(id);
        return diasSemLocacao == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(diasSemLocacao);
    }

    @DeleteMapping("deletarPorId/{id}")
    public ResponseEntity<Void> deletarDiasPorId(int id){
        diasSemLocacaoService.deletarDias(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("atualizarPorId/{id}")
    public ResponseEntity<DiasSemLocacao> atualizarDiasPorId(int id, DiasSemLocacao diasSemLocacao) {
        DiasSemLocacao diaAtualizado = diasSemLocacaoService.atulizarDiaPorId(id, diasSemLocacao);
        return diaAtualizado == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(diaAtualizado);
    }
}
