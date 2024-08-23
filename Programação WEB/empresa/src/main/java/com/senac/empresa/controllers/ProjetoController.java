package com.senac.empresa.controllers;

import com.senac.empresa.entities.Projeto;
import com.senac.empresa.services.ProjetoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/projetos")
public class ProjetoController {

    private ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> getAllProjetos(){
        List<Projeto> projetos = projetoService.getAllProjetos();
        if(projetos.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(projetos);
    }

    @GetMapping("/ativos")
    public ResponseEntity<List<Projeto>> getProjetosAtivos(){
        List<Projeto> projetos = projetoService.getProjetosAtivos();
        if(projetos.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(projetos);
    }
}
