package com.myoshikzu.demo.service;

import com.myoshikzu.demo.entity.Usuario;
import com.myoshikzu.demo.entity.dto.DadosCadastroUsuario;
import com.myoshikzu.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

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
}
