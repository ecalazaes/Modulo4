package com.senac.clima.services;

import com.senac.clima.entities.RegistroMedicao;
import com.senac.clima.repositories.RegistroMedicaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroMedicaoService {

    private RegistroMedicaoRepository registroMedicaoRepository;

    public RegistroMedicaoService(RegistroMedicaoRepository registroMedicaoRepository) {
        this.registroMedicaoRepository = registroMedicaoRepository;
    }

    public List<RegistroMedicao> listarRegistrosMedicoes() {
        return registroMedicaoRepository.findAll();
    }
}
