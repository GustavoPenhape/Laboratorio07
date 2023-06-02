package com.example.lab_07.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "creditos")
@Getter
@Setter
public class Credito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "monto")
    private String monto;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private User usuario;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Column(name = "interes")
    private Double interes;
}
