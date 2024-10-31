package com.github.ecalazaes.ProjetoTeste03.repositories;

import com.github.ecalazaes.ProjetoTeste03.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
