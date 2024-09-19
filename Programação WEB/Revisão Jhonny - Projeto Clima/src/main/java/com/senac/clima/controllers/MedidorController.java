package com.senac.clima.controllers;

import com.senac.clima.services.MedidorService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedidorController {

    private MedidorService medidorService;

    public MedidorController(MedidorService medidorService) {
        this.medidorService = medidorService;
    }
}
