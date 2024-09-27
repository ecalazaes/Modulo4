package com.senac.clima.services;

import com.senac.clima.entities.Municipio;
import com.senac.clima.repositories.MunicipioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioService {

    private final MunicipioRepository municipioRepository;

    public MunicipioService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    public List<Municipio> listarMunicipios() {
        return (municipioRepository.findAll());
    }

    @Transactional
    public Municipio adicionarMunicipio(Municipio municipio) {
        return municipioRepository.save(municipio);
    }

    @Transactional
    public Municipio deletarMunicipioLogico(int id) {
        Municipio municipio = municipioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Municipio com id " + id + " não encontrado"));

        municipio.setStatus(-1);
        return municipioRepository.save(municipio);
    }

    @Transactional
    public Municipio atualizarPorId(int id, Municipio municipio) {
        if (!municipioRepository.existsById(id)) {
            throw new RuntimeException("Municipio com id " + id + " não encontrado");
        }
        municipio.setId(id);
        return municipioRepository.save(municipio);
    }
}
