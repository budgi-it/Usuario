package com.unipampa.budgi.model;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "usuarios")
@Getter
@Setter
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "password", nullable = false)
    private String password;

    public Usuario() {
    }

    public Usuario(Long id, String name, String user, String password) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.password = password;
    }
}