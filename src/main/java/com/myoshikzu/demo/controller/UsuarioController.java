package com.myoshikzu.demo.controller;

import com.myoshikzu.demo.entity.dto.DadosCadastroUsuario;
import com.myoshikzu.demo.entity.dto.DadosDetalhamentoUsuario;
import com.myoshikzu.demo.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder){
        var usuario = usuarioService.insert(dados);
        var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }


}
