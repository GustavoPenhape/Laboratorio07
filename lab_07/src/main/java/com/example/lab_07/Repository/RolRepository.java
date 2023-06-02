package com.example.lab_07.Repository;

import com.example.lab_07.Entity.Rol;
import com.example.lab_07.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}
