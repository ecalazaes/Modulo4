package com.senac.clima.controllers;

import com.senac.clima.entities.Municipio;
import com.senac.clima.services.MunicipioService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("municipios")
public class MunicipioController {

    private MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping("listar")
    public ResponseEntity<List<Municipio>> listarMunicipios() {
        List<Municipio> municipios = municipioService.listarMunicipios();
        return ResponseEntity.ok(municipios);
    }

    @PostMapping("adicionar")
    public ResponseEntity<Municipio> adicionarMunicipio(@RequestBody Municipio municipio) {
        Municipio municipioNovo = municipioService.adicionarMunicipio(municipio);
        return ResponseEntity.status(HttpStatus.CREATED).body(municipioNovo);
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<String> deletarMunicipioLogico(@PathVariable int id) {
        try {
            municipioService.deletarMunicipioLogico(id);
            return ResponseEntity.ok("Município deletado com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<Municipio> atualizarMunicipio(@PathVariable int id, @RequestBody Municipio municipio) {
        municipioService.atualizarPorId(id, municipio);
        return ResponseEntity.ok(municipio);
    }
}