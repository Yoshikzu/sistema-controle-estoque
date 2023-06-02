package com.myoshikzu.demo.entity.dto;

import com.myoshikzu.demo.entity.Produto;

import java.time.LocalDateTime;

public record DadosAtualizacaoProduto(Long id,
                                      String nome,
                                      String codigoBarras,
                                      int quantidadeMinima) {

    public DadosAtualizacaoProduto(Produto produto){
        this(produto.getId(),produto.getNome(),produto.getCodigoBarras(),produto.getQuantidadeMinima());
    }
}

