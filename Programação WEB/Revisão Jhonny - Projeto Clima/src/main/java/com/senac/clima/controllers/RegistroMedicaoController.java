package com.senac.clima.controllers;

import com.senac.clima.services.RegistroMedicaoService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistroMedicaoController {

    private RegistroMedicaoService registroMedicaoService;

    public RegistroMedicaoController(RegistroMedicaoService registroMedicaoService) {
        this.registroMedicaoService = registroMedicaoService;
    }
}
