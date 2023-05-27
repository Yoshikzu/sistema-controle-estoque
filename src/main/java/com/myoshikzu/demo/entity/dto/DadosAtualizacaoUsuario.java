package com.myoshikzu.demo.entity.dto;

import com.myoshikzu.demo.entity.Usuario;
import com.myoshikzu.demo.entity.enums.NivelUsuario;

public record DadosAtualizacaoUsuario(
                                      Long id,
                                      NivelUsuario nivelUsuario,
                                      String nome,
                                      String login,
                                      String senha
                                     ) {

    public DadosAtualizacaoUsuario(Usuario usuario){
        this(usuario.getId(),usuario.getNivelUsuario(),usuario.getNome(),usuario.getLogin(),usuario.getSenha());
    }
}
