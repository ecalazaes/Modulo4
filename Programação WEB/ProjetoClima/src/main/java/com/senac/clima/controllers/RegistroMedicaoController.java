package com.senac.clima.controllers;

import com.senac.clima.entities.RegistroMedicao;
import com.senac.clima.services.RegistroMedicaoService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("registros")
public class RegistroMedicaoController {

    private RegistroMedicaoService registroMedicaoService;

    public RegistroMedicaoController(RegistroMedicaoService registroMedicaoService) {
        this.registroMedicaoService = registroMedicaoService;
    }

    @GetMapping
    public ResponseEntity<List<RegistroMedicao>> listarRegistroMedicoes() {
        List<RegistroMedicao> listaRegistros = registroMedicaoService.listarRegistrosMedicoes();
        return ResponseEntity.ok(listaRegistros);
    }

    @PostMapping("adiconar")
    public ResponseEntity<RegistroMedicao> adicionarRegistroMedicao(RegistroMedicao registroMedicao) {
        RegistroMedicao registroNovo = registroMedicaoService.adicionarRegistroMedicao(registroMedicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(registroNovo);
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletarRegistroLogico(@PathVariable int id) {
        try {
            registroMedicaoService.deletarRegistroLogico(id);
            return ResponseEntity.ok("Registro deletado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<RegistroMedicao> atualizarPorId(@PathVariable int id, @RequestBody RegistroMedicao registroMedicao) {
        registroMedicaoService.atualizarPorId(id, registroMedicao);
        return ResponseEntity.ok(registroMedicao);
    }
}
