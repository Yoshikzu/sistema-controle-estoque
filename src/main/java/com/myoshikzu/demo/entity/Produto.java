package com.myoshikzu.demo.entity;

import com.myoshikzu.demo.entity.dto.DadosCadastroProduto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "codigoBarras")
@Entity(name = "produto")
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String codigoBarras;
    private int quantidadeMinima;
    private int saldoInicial;
    private LocalDateTime dataCadastro = LocalDateTime.now();

    public Produto(DadosCadastroProduto dados){
        this.nome = dados.nome();
        this.codigoBarras = dados.codigoBarras();
        this.quantidadeMinima = dados.quantidadeMinima();
        this.saldoInicial = dados.saldoInicial();
    }
}
