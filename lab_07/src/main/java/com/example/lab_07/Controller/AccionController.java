package com.example.lab_07.Controller;

import com.example.lab_07.Entity.Accion;
import com.example.lab_07.Repository.AccionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value="/acciones")
public class AccionController {
    final AccionRepository accionRepository;

    public AccionController(AccionRepository accionRepository) {
        this.accionRepository = accionRepository;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<HashMap<String, Object>> guardarAccion(
            @RequestBody Accion nuevaAccion) {
        Accion accionGuardada = accionRepository.save(nuevaAccion);
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("idCreado", accionGuardada.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }
}
