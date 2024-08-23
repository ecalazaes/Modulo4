package rj.senac.br.TestAPI.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import rj.senac.br.TestAPI.repositories.EmpresaRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final EmpresaRepository empresaRepository;

    public Instantiation(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

//        Empresa empresa1 = new Empresa(null, "Empresa Teste1", "14275282000144", "empretateste1@gmail.com");
//        Empresa empresa2 = new Empresa(null, "Empresa Teste2", "14275282000225", "empretateste2@gmail.com");
//        Empresa empresa3 = new Empresa(null, "Empresa Teste3", "00000000000000", "empretateste3@gmail.com");
//
//        empresaRepository.saveAll(Arrays.asList(empresa1, empresa2, empresa3));
    }
}
