package com.julio.backfindt.repository;

import com.julio.backfindt.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
    Optional<Pessoa> findByCpf(String cpf);
}
