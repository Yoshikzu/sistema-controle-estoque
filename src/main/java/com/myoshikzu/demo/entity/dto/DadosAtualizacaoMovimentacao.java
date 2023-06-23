package com.myoshikzu.demo.entity.dto;

import com.myoshikzu.demo.entity.Movimentacao;
import com.myoshikzu.demo.entity.enums.TipoMovimento;

import java.time.LocalDateTime;

public record DadosAtualizacaoMovimentacao(Long idMovimentacao,
                                           Long idProduto,
                                           TipoMovimento tipoMovimento,
                                           int quantidade,
                                           LocalDateTime dataMovimentacao) {

    public DadosAtualizacaoMovimentacao(Movimentacao movimentacao){
        this(movimentacao.getId(),movimentacao.getProduto().getId(),movimentacao.getTipoMovimento(),movimentacao.getQuantidade(),movimentacao.getDataMovimentacao());
    }
}
