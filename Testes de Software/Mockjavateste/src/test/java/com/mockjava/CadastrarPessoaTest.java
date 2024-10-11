package com.mockjava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTest {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void testCadastrarPessoa(){
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("SP", "Atibaia", "Av. Brasil", "Casa", "Centro");

        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("12940-330")).thenReturn(dadosLocalizacao);

        Pessoa erick = cadastrarPessoa.cadastrarPessoa("Erick", "12345678", LocalDate.of(2003, 03, 11), "12940-330");

        DadosLocalizacao enderecoErick = erick.getEndereco();

        assertEquals(dadosLocalizacao.getBairro(), enderecoErick.getBairro());
        assertEquals(dadosLocalizacao.getCidade(), enderecoErick.getCidade());
        assertEquals(dadosLocalizacao.getUf(), enderecoErick.getUf());
    }

    @Test
    void tentaCadastrarPessoaMasSistemasEstaForaDoAr(){
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("12940-330")).thenThrow(RuntimeException.class);

        Assertions.assertThrows(RuntimeException.class, () -> cadastrarPessoa.cadastrarPessoa("Erick", "12345678", LocalDate.of(2003, 03, 11), "12940-330"));
    }
}
