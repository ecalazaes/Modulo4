package com.senac.clima.controllers;

import com.senac.clima.entities.Medidor;
import com.senac.clima.services.MedidorService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medidores")
public class MedidorController {

    private MedidorService medidorService;

    public MedidorController(MedidorService medidorService) {
        this.medidorService = medidorService;
    }

    @GetMapping("listar")
    public ResponseEntity<List<Medidor>> listarMedidores() {
        List<Medidor> medidores = medidorService.listarMedidor();
        return ResponseEntity.ok(medidores);
    }

    @PostMapping("adicionar")
    @Transactional
    public ResponseEntity<Medidor> adicionarMedidor(@RequestBody Medidor medidor) {
        Medidor medidorNovo = medidorService.adicionarMedidor(medidor);
        return ResponseEntity.status(HttpStatus.CREATED).body(medidorNovo);
    }

    @DeleteMapping("deletar/{id}")
    @Transactional
    public ResponseEntity<String> deletarMedidorLogico(@PathVariable int id) {
        try {
            medidorService.deletarMedidorLogico(id);
            return ResponseEntity.ok("Medidor deletado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("atualizar/{id}")
    @Transactional
    public ResponseEntity<Medidor> atualizarMedidor(@PathVariable int id, @RequestBody Medidor medidor) {
        medidorService.atualizarPorId(id, medidor);
        return ResponseEntity.ok(medidor);
    }
}
