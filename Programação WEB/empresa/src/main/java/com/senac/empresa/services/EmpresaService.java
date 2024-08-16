package com.senac.empresa.services;

import com.senac.empresa.entities.Empresa;
import com.senac.empresa.repositories.EmpresaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Transactional
    public List<Empresa> getAllEmpresas(){
        return empresaRepository.findAll();
    }
}
