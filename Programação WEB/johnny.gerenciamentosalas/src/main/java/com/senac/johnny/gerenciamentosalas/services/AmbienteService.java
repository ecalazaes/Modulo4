package com.senac.johnny.gerenciamentosalas.services;

import com.senac.johnny.gerenciamentosalas.entities.Ambiente;
import com.senac.johnny.gerenciamentosalas.entities.Usuario;
import com.senac.johnny.gerenciamentosalas.repositories.AmbienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmbienteService {

    private AmbienteRepository ambienteRepository;

    public AmbienteService(AmbienteRepository ambienteRepository) {
        this.ambienteRepository = ambienteRepository;
    }

    public List<Ambiente> listAmbientes(){
        return ambienteRepository.findAll();
    }

    public Ambiente saveAmbiente(Ambiente ambiente) {
        return ambienteRepository.save(ambiente);
    }

    public Ambiente listarPorId(int id) {
        return ambienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ambiente não encontrado"));
    }

    public void deletarAmbiente(int id) {
        ambienteRepository.deleteById(id);
    }

    public Ambiente atualizarAmbiente(int id, Ambiente ambiente) {
        Ambiente ambienteExistente =  ambienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ambiente não encontrado com o ID: " + id));
        ambiente.setId(id);
        return ambienteRepository.save(ambienteExistente);
    }
}
