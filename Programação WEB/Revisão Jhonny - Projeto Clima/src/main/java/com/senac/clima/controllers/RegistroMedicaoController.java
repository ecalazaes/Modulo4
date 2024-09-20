package com.senac.clima.controllers;

import com.senac.clima.entities.RegistroMedicao;
import com.senac.clima.services.RegistroMedicaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroMedicaoController {

    private RegistroMedicaoService registroMedicaoService;

    public RegistroMedicaoController(RegistroMedicaoService registroMedicaoService) {
        this.registroMedicaoService = registroMedicaoService;
    }

    @GetMapping
    public ResponseEntity<List<RegistroMedicao>> listarRegistroMedicoes(){
        List<RegistroMedicao> listaRegistros = registroMedicaoService.listarRegistrosMedicoes();
        return ResponseEntity.ok(listaRegistros);
    }
}
