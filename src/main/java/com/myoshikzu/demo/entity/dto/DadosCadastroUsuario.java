package com.myoshikzu.demo.entity.dto;

import com.myoshikzu.demo.entity.enums.NivelUsuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroUsuario(
                                   @NotNull(message = "{nivelUsuario.obrigatorio}")
                                   NivelUsuario nivelUsuario,
                                   @NotBlank(message = "{nome.obrigatorio}")
                                   String nome,
                                   @NotBlank(message = "{email.obrigatorio}")
                                   @Email(message = "{email.invalido}")
                                   String email,
                                   @NotBlank(message = "{login.obrigatorio}")
                                   String login,
                                   @NotBlank(message = "{senha.obrigatoria}")
                                   String senha
                                   ) {
}
