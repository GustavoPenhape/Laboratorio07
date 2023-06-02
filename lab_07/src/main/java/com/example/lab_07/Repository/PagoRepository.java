package com.example.lab_07.Repository;

import com.example.lab_07.Entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository   extends JpaRepository<Pago, Integer> {
}
