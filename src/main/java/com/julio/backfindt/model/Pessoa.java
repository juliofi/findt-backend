package com.julio.backfindt.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Login id;

    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String genero;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;
}
