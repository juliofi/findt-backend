package com.julio.backfindt.service;

import com.julio.backfindt.model.Pessoa;
import com.julio.backfindt.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> listarTodos() {
        return repository.findAll();
    }

    public Optional<Pessoa> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Optional<Pessoa> buscarPorCpf(String cpf){
        return repository.findByCpf(cpf);
    }

    public Pessoa salvar(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
