package com.senac.empresa.controllers;

import com.senac.empresa.entities.Empresa;
import com.senac.empresa.services.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        List<Empresa> empresas = empresaService.getAllEmpresas();
        if(empresas.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(empresas);
    }
}
