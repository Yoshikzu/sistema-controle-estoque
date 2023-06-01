package com.myoshikzu.demo.entity.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroProduto(@NotBlank(message = "{produtonome.obrigatorio}")
                                   String nome,
                                   @NotBlank(message = "{produtocodigobarras.obrigatorio}")
                                   String codigoBarras,
                                   int quantidadeMinima,
                                   int saldoInicial
                                   ) {
}
