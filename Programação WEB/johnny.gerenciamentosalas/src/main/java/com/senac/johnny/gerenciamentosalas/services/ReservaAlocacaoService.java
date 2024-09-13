package com.senac.johnny.gerenciamentosalas.services;

import com.senac.johnny.gerenciamentosalas.entities.ReservaAlocacao;
import com.senac.johnny.gerenciamentosalas.repositories.ReserveAlocacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaAlocacaoService {

    private ReserveAlocacaoRepository reserveAlocacaoRepository;

    public ReservaAlocacaoService(ReserveAlocacaoRepository reserveAlocacaoRepository) {
        this.reserveAlocacaoRepository = reserveAlocacaoRepository;
    }

    public List<ReservaAlocacao> listarReservas(){
        return reserveAlocacaoRepository.findAll();
    }
}
