package com.senac.clima.services;

import com.senac.clima.repositories.MedidorRepository;
import org.springframework.stereotype.Service;

@Service
public class MedidorService {

    private MedidorRepository medidorRepository;

    public MedidorService(MedidorRepository medidorRepository) {
        this.medidorRepository = medidorRepository;
    }
}
