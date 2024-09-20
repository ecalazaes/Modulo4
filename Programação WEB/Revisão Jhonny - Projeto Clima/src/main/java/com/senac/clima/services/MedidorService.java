package com.senac.clima.services;

import com.senac.clima.entities.Medidor;
import com.senac.clima.repositories.MedidorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedidorService {

    private MedidorRepository medidorRepository;

    public MedidorService(MedidorRepository medidorRepository) {
        this.medidorRepository = medidorRepository;
    }

    public List<Medidor> listarMedidor() {
        return medidorRepository.findAll();
    }
}
