package com.myoshikzu.demo.entity.dto;

import com.myoshikzu.demo.entity.Movimentacao;
import com.myoshikzu.demo.entity.Produto;
import com.myoshikzu.demo.entity.enums.TipoMovimento;

import java.time.LocalDateTime;

public record DadosDetalhamentoMovimentacao(Produto produto,
                                            TipoMovimento tipoMovimento,
                                            int quantidade,
                                            LocalDateTime dataMovimentacao) {

    public DadosDetalhamentoMovimentacao(Movimentacao movimentacao){
        this(movimentacao.getProduto(),movimentacao.getTipoMovimento(),movimentacao.getQuantidade(),movimentacao.getDataMovimentacao());
    }
}
