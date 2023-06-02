package com.example.lab_07.Controller;

import com.example.lab_07.Entity.Solicitud;
import com.example.lab_07.Repository.SolicitudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping(value="/solicitudes")
public class SolicitudController {
    final SolicitudRepository solicitudRepository;

    public SolicitudController(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    @PostMapping(value = "/registro")
    public ResponseEntity<HashMap<String, Object>> guardarSolicitud(
            @RequestBody Solicitud solicitud) {
        // Coloca el estado de la solicitud como pendiente
        solicitud.setSolicitud_estado("pendiente");

        // Guarda la solicitud
        solicitudRepository.save(solicitud);

        // Prepara la respuesta
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("Monto solicitado", solicitud.getSolicitud_monto());
        responseMap.put("id", solicitud.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }

    @PutMapping(value = "/aprobarSolicitud")
    public ResponseEntity<HashMap<String, Object>> aprobarSolicitud(
            @RequestParam(value = "idSolicitud") Integer idSolicitud) {
        // Busca la solicitud por su ID
        Optional<Solicitud> optionalSolicitud = solicitudRepository.findById(idSolicitud);
        if (optionalSolicitud.isPresent()) {
            Solicitud solicitud = optionalSolicitud.get();

            // Verifica si la solicitud está en estado "pendiente"
            if (solicitud.getSolicitud_estado().equals("pendiente")) {
                // Cambia el estado de la solicitud a "aprobada"
                solicitud.setSolicitud_estado("aprobada");

                // Guarda la solicitud actualizada
                solicitudRepository.save(solicitud);

                // Prepara la respuesta
                HashMap<String, Object> responseMap = new HashMap<>();
                responseMap.put("id solicitud", solicitud.getId());
                return ResponseEntity.ok(responseMap);
            } else {
                // Si la solicitud no está en estado "pendiente", devuelve el objeto JSON correspondiente
                HashMap<String, Object> responseMap = new HashMap<>();
                responseMap.put("solicitud ya atendida", solicitud.getId());
                return ResponseEntity.ok(responseMap);
            }
        } else {
            // Si no se encuentra la solicitud, devuelve una respuesta de error
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping(value = "/denegarSolicitud")
    public ResponseEntity<HashMap<String, Object>> denegarSolicitud(
            @RequestParam(value = "idSolicitud") Integer idSolicitud) {
        // Busca la solicitud por su ID
        Optional<Solicitud> optionalSolicitud = solicitudRepository.findById(idSolicitud);
        if (optionalSolicitud.isPresent()) {
            Solicitud solicitud = optionalSolicitud.get();

            // Verifica si la solicitud está en estado "pendiente"
            if (solicitud.getSolicitud_estado().equals("pendiente")) {
                // Cambia el estado de la solicitud a "denegada"
                solicitud.setSolicitud_estado("denegada");

                // Guarda la solicitud actualizada
                solicitudRepository.save(solicitud);

                // Prepara la respuesta
                HashMap<String, Object> responseMap = new HashMap<>();
                responseMap.put("id solicitud", solicitud.getId());
                return ResponseEntity.ok(responseMap);
            } else {
                // Si la solicitud no está en estado "pendiente", devuelve la respuesta correspondiente
                HashMap<String, Object> responseMap = new HashMap<>();
                responseMap.put("solicitud ya atendida", solicitud.getId());
                return ResponseEntity.ok(responseMap);
            }
        } else {
            // Si no se encuentra la solicitud, devuelve una respuesta de error
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }



}
