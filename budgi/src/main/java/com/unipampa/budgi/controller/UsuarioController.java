package com.unipampa.budgi.controller;

import com.unipampa.budgi.model.Usuario;
import com.unipampa.budgi.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/Usuario")
@CrossOrigin(origins = "*")
@Api(value = "API REST usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping(value = "/getAll")
    @ApiOperation(value = "Retorna uma lista de Usuarios")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retornou uma lista de Usuarios"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public List<Usuario> listAllUsuarios() {
        return service.listAllUsuarios();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Retorna uma Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Pesquisou por id e retornou uma Usuario"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public Usuario findById(@PathVariable(name = "id") Integer id) {
        return service.findById(id);
    }

    @PostMapping(value = "/saveUsuario")
    @ApiOperation(value = "Cadastro de Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cadastrou uma Usuario"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public Usuario saveUsuario(@RequestBody Usuario usuario) {
        return service.saveUsuario(usuario);
    }

    @PutMapping(value = "/updateUsuario")
    @ApiOperation(value = "Atualiza as informações de uma Usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Atualizou uma Usuario"),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario) {
        service.updateUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Deleta uma Usuario por id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Deletou uma Usuario "),
            @ApiResponse(code = 403, message = "Você não tem permissão para acessar este recurso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    public ResponseEntity<?> deleteUsuario(@PathVariable(value = "id") Integer id) {
        service.deleteUsuarioById(id);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<Usuario> findByUsuario(@RequestParam String usuario){
        Usuario usuarioResponse = service.findByUsuario(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponse);
    }
}
