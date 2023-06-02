package com.example.lab_07.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="usuarios")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="correo")
    private String correo;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="estado_logico")
    private String estado_logico;

    @ManyToOne
    @JoinColumn(name="rol_id")
    private Rol rol_id;

    @Column(name = "fecha_registro")
    private String fecha_registro;

}