package rj.senac.br.TestAPI.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rj.senac.br.TestAPI.entities.Empresa;
import rj.senac.br.TestAPI.services.EmpresaService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> getAllEmpresas() {
        List<Empresa> list = empresaService.getAllEmpresas();
        return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> getEmpresaById(@PathVariable Long id) {
        try {
            Empresa empresa = empresaService.getEmpresaById(id);
            return ResponseEntity.ok(empresa);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Empresa> insertEmpresa(@Valid @RequestBody Empresa empresa) {
        Empresa createdEmpresa = empresaService.insertEmpresa(empresa);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEmpresa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id) {
        try {
            empresaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
//    @PutMapping(value = "/{id}")
}
