package com.unipampa.budgi.service;

import com.unipampa.budgi.model.Usuario;
import com.unipampa.budgi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public List<Usuario> listAllUsuarios(){
        return repository.findAll();
    }

    public Usuario findById(long id){
        return repository.findById(id);
    }

    public Usuario saveUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario){
        return repository.save(usuario);
    }

    public void deleteUsuarioById(long id){
        repository.deleteById(id);
    }
}
