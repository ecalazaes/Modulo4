package com.senac.clima.controllers;

import com.senac.clima.entities.Medidor;
import com.senac.clima.services.MedidorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medidores")
public class MedidorController {

    private MedidorService medidorService;

    public MedidorController(MedidorService medidorService) {
        this.medidorService = medidorService;
    }

    @GetMapping
    public ResponseEntity<List<Medidor>> listarMedidores() {
        List<Medidor> medidores = medidorService.listarMedidor();
        return ResponseEntity.ok(medidores);
    }
}
