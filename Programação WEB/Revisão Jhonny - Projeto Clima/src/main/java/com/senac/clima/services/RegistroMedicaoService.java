package com.senac.clima.services;

import com.senac.clima.entities.RegistroMedicao;
import com.senac.clima.repositories.RegistroMedicaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroMedicaoService {

    private final RegistroMedicaoRepository registroMedicaoRepository;

    public RegistroMedicaoService(RegistroMedicaoRepository registroMedicaoRepository) {
        this.registroMedicaoRepository = registroMedicaoRepository;
    }

    public List<RegistroMedicao> listarRegistrosMedicoes() {
        return registroMedicaoRepository.findAll();
    }

    public RegistroMedicao adicionarRegistroMedicao(RegistroMedicao registroMedicao) {
        return registroMedicaoRepository.save(registroMedicao);
    }

    public RegistroMedicao deletarRegistroLogico(int id) {
        RegistroMedicao registroMedicao = registroMedicaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro com id " + id + " não encontrado"));

        registroMedicao.setStatus(-1);
        return registroMedicaoRepository.save(registroMedicao);
    }

    public RegistroMedicao atualizarPorId(int id, RegistroMedicao registroMedicao) {
        if (!registroMedicaoRepository.existsById(id)) {
            throw new RuntimeException("Registro com id " + id + " não encontrado");
        }
        registroMedicao.setId(id);
        return registroMedicaoRepository.save(registroMedicao);
    }
}
