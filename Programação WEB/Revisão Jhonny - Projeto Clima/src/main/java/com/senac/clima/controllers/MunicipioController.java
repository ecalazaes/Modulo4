package com.senac.clima.controllers;

import com.senac.clima.services.MunicipioService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MunicipioController {

    private MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }
}
