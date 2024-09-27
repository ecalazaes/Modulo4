package com.senac.johnny.gerenciamentosalas.services;

import com.senac.johnny.gerenciamentosalas.entities.DiasSemLocacao;
import com.senac.johnny.gerenciamentosalas.repositories.DiasSemLocacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiasSemLocacaoService {

    private final DiasSemLocacaoRepository diasSemLocacaoRepository;

    public DiasSemLocacaoService(DiasSemLocacaoRepository diasSemLocacaoRepository) {
        this.diasSemLocacaoRepository = diasSemLocacaoRepository;
    }

    public List<DiasSemLocacao> listarDias(){
        return diasSemLocacaoRepository.findAll();
    }

    public DiasSemLocacao saveDias(DiasSemLocacao diasSemLocacao) {
        return diasSemLocacaoRepository.save(diasSemLocacao);
    }

    public DiasSemLocacao listarPorId(int id) {
        return diasSemLocacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dias não encontrado com ID: " + id));
    }

    public void deletarDias(int id){
        diasSemLocacaoRepository.deleteById(id);
    }

    public DiasSemLocacao atulizarDiaPorId(int id, DiasSemLocacao diasSemLocacao){
        DiasSemLocacao diaExistente =  diasSemLocacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dia não encontrado com o ID: " + id));

        diasSemLocacao.setId(id);
        return diasSemLocacaoRepository.save(diaExistente);
    }

}
