package com.myoshikzu.demo.service;

import com.myoshikzu.demo.entity.Usuario;
import com.myoshikzu.demo.entity.dto.DadosAtualizacaoUsuario;
import com.myoshikzu.demo.entity.dto.DadosCadastroUsuario;
import com.myoshikzu.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario insert(DadosCadastroUsuario dados){
        if (usuarioRepository.findUsuarioByLogin(dados.login()) != null){
            throw new RuntimeException("Login já cadastrado no sistema!");
        }

        var usuario =  new Usuario(dados);
        usuarioRepository.save(usuario);
        return usuario;
    }

    public Page<Usuario> getAll (Pageable paginacao){
        return usuarioRepository.findAll(paginacao);
    }

    public Usuario getUsuario(Long id){
        var usuario = usuarioRepository.findById(id).orElse(null);
        if(usuario == null){
            throw new RuntimeException("Usuário (id: " +  id + ") não cadastrado no sistema!");
        }
        return usuario;
    }

    public Usuario update(DadosAtualizacaoUsuario dados){
        var usuario = this.getUsuario(dados.id());

        if(dados.nivelUsuario() != null && dados.nivelUsuario() != usuario.getNivelUsuario()){
            usuario.setNivelUsuario(dados.nivelUsuario());
        }

        if(dados.nome() != null && dados.nome() != usuario.getNome()){
            usuario.setNome(dados.nome());
        }

        if(dados.login() != null && dados.login() != usuario.getLogin()){
            usuario.setLogin(dados.login());
        }

        if(dados.senha() != null && dados.senha() != usuario.getSenha()){
            usuario.setSenha(dados.senha());
        }

        usuarioRepository.save(usuario);
        return usuario;
    }

    public void delete(Long id){
        var usuario = this.getUsuario(id);
        usuarioRepository.delete(usuario);
    }

}
