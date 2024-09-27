package com.senac.clima.services;

import com.senac.clima.entities.Medidor;
import com.senac.clima.entities.Municipio;
import com.senac.clima.repositories.MedidorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedidorService {

    private final MedidorRepository medidorRepository;

    public MedidorService(MedidorRepository medidorRepository) {
        this.medidorRepository = medidorRepository;
    }

    public List<Medidor> listarMedidor() {
        return medidorRepository.findAll();
    }

    public Medidor adicionarMedidor(Medidor medidor){
        return medidorRepository.save(medidor);
    }

    public Medidor deletarMedidorLogico(int id){
        Medidor medidor = medidorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medidor com id " + id + " não encontrado"));

        medidor.setStatus(-1);
        return medidorRepository.save(medidor);
    }

    public Medidor atualizarPorId(int id, Medidor medidor) {
        if (!medidorRepository.existsById(id)) {
            throw new RuntimeException("Medidor com id " + id + " não encontrado");
        }
        medidor.setId(id);
        return medidorRepository.save(medidor);
    }
}
