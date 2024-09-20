package com.senac.clima.repositories;

import com.senac.clima.entities.RegistroMedicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroMedicaoRepository extends JpaRepository<RegistroMedicao, Integer> {
}
