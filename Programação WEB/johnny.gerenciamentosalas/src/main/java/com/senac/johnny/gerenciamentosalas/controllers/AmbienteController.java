package com.senac.johnny.gerenciamentosalas.controllers;

import com.senac.johnny.gerenciamentosalas.entities.Ambiente;
import com.senac.johnny.gerenciamentosalas.entities.Usuario;
import com.senac.johnny.gerenciamentosalas.services.AmbienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ambientes")
public class AmbienteController {

    private AmbienteService ambienteService;

    public AmbienteController(AmbienteService ambienteService) {
        this.ambienteService = ambienteService;
    }

    @GetMapping
    public ResponseEntity<List<Ambiente>> listarAmbientes() {
        List<Ambiente> ambientes = ambienteService.listAmbientes();
        return ResponseEntity.ok(ambientes);
    }

    @PostMapping
    public ResponseEntity<Ambiente> saveAmbiente(@RequestBody Ambiente ambiente) {
        Ambiente novoAmbiente = ambienteService.saveAmbiente(ambiente);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAmbiente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ambiente> listarPorId(@PathVariable int id) {
        Ambiente ambiente = ambienteService.listarPorId(id);
        return ambiente == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(ambiente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAmbiente(@PathVariable int id) {
        ambienteService.deletarAmbiente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ambiente> atualizarAmbiente(@PathVariable int id, @RequestBody Ambiente ambiente) {
        Ambiente ambienteAtualizado = ambienteService.atualizarAmbiente(id, ambiente);
        return ambienteAtualizado == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(ambienteAtualizado);
    }
}
