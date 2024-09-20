package com.senac.clima.services;

import com.senac.clima.entities.Municipio;
import com.senac.clima.repositories.MunicipioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioService {

    private MunicipioRepository municipioRepository;

    public MunicipioService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }

    public List<Municipio> listarMunicipios(){
        return (municipioRepository.findAll());
    }
}
