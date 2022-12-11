package com.unipampa.budgi.repository;

import com.unipampa.budgi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findById(long id);

    Usuario findByUser(String usuario);
}
