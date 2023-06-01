package com.myoshikzu.demo.entity.dto;

import com.myoshikzu.demo.entity.Produto;

import java.time.LocalDateTime;

public record DadosDetalhamentoProduto(Long id,
                                       String nome,
                                       String codigoBarras,
                                       int quantidadeMinima,
                                       int saldoInicial,
                                       LocalDateTime dataCadastro) {

    public DadosDetalhamentoProduto(Produto produto){
        this(produto.getId(),produto.getNome(),produto.getCodigoBarras(),produto.getQuantidadeMinima(), produto.getSaldoInicial(), produto.getDataCadastro());
    }
}
