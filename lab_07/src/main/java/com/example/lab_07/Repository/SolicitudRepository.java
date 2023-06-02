package com.example.lab_07.Repository;

import com.example.lab_07.Entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository  extends JpaRepository<Solicitud, Integer> {
}
