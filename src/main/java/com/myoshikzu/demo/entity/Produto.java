package com.myoshikzu.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "codigoBarra")
@Entity
@Table(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String codigoBarras;
    private int quantidadeMinima;
    private int saldoInicial;
    private LocalDateTime dataCadastro = LocalDateTime.now();
}
