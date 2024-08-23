package rj.senac.br.TestAPI.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rj.senac.br.TestAPI.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
