package com.myoshikzu.demo.entity.dto;

import com.myoshikzu.demo.entity.Produto;
import com.myoshikzu.demo.entity.enums.TipoMovimento;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCadastroMovimentacao(
                                        @NotNull(message = "{produto.obrigatorio}")
                                        Long idProduto,
                                        @NotNull(message = "{tipoMovimento.obrigatorio}")
                                        TipoMovimento tipoMovimento,
                                        int quantidade,
                                        LocalDateTime dataMovimentacao) {
}
