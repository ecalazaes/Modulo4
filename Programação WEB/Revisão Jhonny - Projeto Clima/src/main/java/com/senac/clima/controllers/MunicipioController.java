package com.senac.clima.controllers;

import com.senac.clima.entities.Municipio;
import com.senac.clima.services.MunicipioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    private MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping
    public ResponseEntity<List<Municipio>> listarMunicipios() {
        List<Municipio> municipios = municipioService.listarMunicipios();
        return ResponseEntity.ok(municipios);
    }
}
