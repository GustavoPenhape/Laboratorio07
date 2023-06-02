package com.example.lab_07.Controller;

import com.example.lab_07.Entity.Pago;
import com.example.lab_07.Repository.PagoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/pagos")
public class PagoController {
    final PagoRepository pagoRepository;

    public PagoController(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @GetMapping(value = "/listarPagos")
    public List<Pago> listarPagos() {
        return pagoRepository.findAll();
    }

    @PostMapping(value = "/registrarPago")
    public ResponseEntity<HashMap<String, Object>> registrarPago(
            @RequestBody Pago nuevoPago) {
        Pago pagoGuardado = pagoRepository.save(nuevoPago);
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("id", pagoGuardado.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }
}

