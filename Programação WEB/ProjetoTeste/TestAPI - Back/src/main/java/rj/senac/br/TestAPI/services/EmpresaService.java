package rj.senac.br.TestAPI.services;

import jakarta.persistence.EntityNotFoundException;
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

    public List<Empresa> getAllEmpresas() {
        return empresaRepository.findAll();
    }

    public Empresa getEmpresaById(Long id) {
        return empresaRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Empresa não encontrada com o id: " + id));
    }

    public Empresa insertEmpresa(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void deleteById(Long id) {
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Empresa não encontrada com o id: " + id);
        }
    }

    public Empresa updateEmpresa(Long id, Empresa empresa) {
        return empresaRepository.findById(id)
                .map(empresaEncontrada -> {
                    empresaEncontrada.setNome(empresa.getNome());
                    empresaEncontrada.setCnpj(empresa.getCnpj());
                    empresaEncontrada.setEmail(empresa.getEmail());
                    return empresaRepository.save(empresaEncontrada);
                })
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada com o id: " + id));
    }
}
