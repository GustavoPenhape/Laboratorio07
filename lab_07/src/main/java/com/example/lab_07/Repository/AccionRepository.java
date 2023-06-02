package com.example.lab_07.Repository;

import com.example.lab_07.Entity.Accion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccionRepository extends JpaRepository<Accion, Integer> {
}
