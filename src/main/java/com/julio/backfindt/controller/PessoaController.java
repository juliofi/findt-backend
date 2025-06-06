package com.julio.backfindt.controller;

import com.julio.backfindt.dto.BuscaCpfDTO;
import com.julio.backfindt.model.Pessoa;
import com.julio.backfindt.service.PessoaService;
import com.julio.backfindt.dto.PessoaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins = "*")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public List<Pessoa> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Pessoa> buscarPorCpf(@PathVariable String cpf) {
        return service.buscarPorCpf(cpf)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody PessoaDTO pessoaDTO){
        Pessoa pessoa = new Pessoa(
                pessoaDTO.getNomeCompleto(),
                pessoaDTO.getCpf(),
                pessoaDTO.getGenero(),
                pessoaDTO.getDataNascimento()
        );

        Pessoa pessoaSalva = service.salvar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pessoa> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/buscar/cpf")
    public ResponseEntity<Pessoa> buscarPorCpf(@RequestBody BuscaCpfDTO buscaCpfDTO){
        return service.buscarPorCpf(buscaCpfDTO.getCpf())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/buscar/nome")
    public ResponseEntity<List<Pessoa>> buscarPorNome(@RequestBody Map<String, String> request){
        String nomeCompleto = request.get("nomeCompleto");
        List<Pessoa> resultados = service.buscarPorNomeCompleto(nomeCompleto);
        return ResponseEntity.ok(resultados);
    }
}
