package com.github.ecalazaes.ProjetoModalBack.repositories;

import com.github.ecalazaes.ProjetoModalBack.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostiory extends JpaRepository<User, Long> {
}
