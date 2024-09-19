package com.senac.clima.services;

import com.senac.clima.repositories.MunicipioRepository;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService {

    private MunicipioRepository municipioRepository;

    public MunicipioService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
    }
}
