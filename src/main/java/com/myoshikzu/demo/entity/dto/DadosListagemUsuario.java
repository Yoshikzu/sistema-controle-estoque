package com.myoshikzu.demo.entity.dto;

import com.myoshikzu.demo.entity.Usuario;
import com.myoshikzu.demo.entity.enums.NivelUsuario;

public record DadosListagemUsuario(Long id,
                                   NivelUsuario nivelUsuario,
                                   String nome,
                                   String email,
                                   String login) {

    public DadosListagemUsuario(Usuario usuario){
        this(usuario.getId(),usuario.getNivelUsuario(),usuario.getNome(), usuario.getEmail(), usuario.getLogin());
    }
}
