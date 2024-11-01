package com.senac.clima.repositories;

import com.senac.clima.entities.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository <Municipio, Integer> {
}
