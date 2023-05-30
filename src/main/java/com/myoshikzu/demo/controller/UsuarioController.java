package com.myoshikzu.demo.controller;

import com.myoshikzu.demo.entity.dto.DadosAtualizacaoUsuario;
import com.myoshikzu.demo.entity.dto.DadosCadastroUsuario;
import com.myoshikzu.demo.entity.dto.DadosDetalhamentoUsuario;
import com.myoshikzu.demo.entity.dto.DadosListagemUsuario;
import com.myoshikzu.demo.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuario>> listar(@PageableDefault(size = 10,sort = {"nome"}) Pageable paginacao){
        return ResponseEntity.ok(usuarioService.getAll(paginacao).map(DadosListagemUsuario::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharUsuario(@PathVariable Long id){
        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuarioService.getUsuario(id)));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados){
        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuarioService.update(dados)));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
