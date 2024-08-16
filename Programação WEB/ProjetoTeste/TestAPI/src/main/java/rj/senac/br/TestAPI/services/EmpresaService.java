package rj.senac.br.TestAPI.services;

import org.springframework.stereotype.Service;
import rj.senac.br.TestAPI.entities.Empresa;
import rj.senac.br.TestAPI.repositories.EmpresaRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public List<Empresa> getAllEmpresas(){
        return empresaRepository.findAll();
    }

    public Empresa getEmpresaById(Long id) {
        return empresaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Empresa não encontrada"));
    }

    public Empresa insertEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deleteById(Long id) {
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Empresa não encontrada");
        }
    }
}
