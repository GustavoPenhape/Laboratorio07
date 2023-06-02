package com.example.lab_07.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "solicitudes")
@Getter
@Setter
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "solicitud_producto")
    private String solicitud_producto;

    @Column(name = "solicitud_monto")
    private Double solicitud_monto;

    @Column(name = "solicitud_fecha")
    private LocalDate solicitud_fecha;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private User usuarios_id;

    @Column(name = "solicitud_estado")
    private String solicitud_estado;
}
