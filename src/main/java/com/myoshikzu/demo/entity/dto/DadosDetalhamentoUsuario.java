package com.myoshikzu.demo.entity.dto;

import com.myoshikzu.demo.entity.Usuario;
import com.myoshikzu.demo.entity.enums.NivelUsuario;

public record DadosDetalhamentoUsuario(
                                        Long id,
                                        NivelUsuario nivelUsuario,
                                        String nome,
                                        String email,
                                        String login,
                                        String senha) {

    public DadosDetalhamentoUsuario(Usuario usuario){
        this(usuario.getId(),usuario.getNivelUsuario(),usuario.getNome(),usuario.getEmail(),usuario.getLogin(),usuario.getSenha());
    }
}
