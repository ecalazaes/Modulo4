package com.senac.clima.services;

import com.senac.clima.repositories.RegistroMedicaoRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistroMedicaoService {

    private RegistroMedicaoRepository registroMedicaoRepository;

    public RegistroMedicaoService(RegistroMedicaoRepository registroMedicaoRepository) {
        this.registroMedicaoRepository = registroMedicaoRepository;
    }
}
