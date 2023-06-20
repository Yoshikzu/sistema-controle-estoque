package com.myoshikzu.demo.entity.dto;

import com.myoshikzu.demo.entity.Movimentacao;
import com.myoshikzu.demo.entity.enums.TipoMovimento;
import java.time.LocalDateTime;

public record DadosListagemMovimentacao(Long idProduto,
                                        TipoMovimento tipoMovimento,
                                        int quantidade,
                                        LocalDateTime dataMovimentacao) {

    public DadosListagemMovimentacao(Movimentacao movimentacao){
        this(movimentacao.getProduto().getId(),movimentacao.getTipoMovimento(), movimentacao.getQuantidade(),movimentacao.getDataMovimentacao());
    }
}
