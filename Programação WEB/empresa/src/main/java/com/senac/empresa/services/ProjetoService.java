package com.senac.empresa.services;

import com.senac.empresa.entities.Projeto;
import com.senac.empresa.repositories.ProjetoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    private ProjetoRepository projetoRepository;

    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    @Transactional
    public List<Projeto> getAllProjetos(){
        return projetoRepository.findAll();
    }

    @Transactional
    public List<Projeto> getProjetosAtivos() {
        return projetoRepository.getProjetosAtivos();
    }
}
