package com.example.lab_07.Controller;

import com.example.lab_07.Entity.Solicitud;
import com.example.lab_07.Entity.User;
import com.example.lab_07.Repository.RolRepository;
import com.example.lab_07.Repository.SolicitudRepository;
import com.example.lab_07.Repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {
    final UserRepository userRepository;
    final RolRepository rolRepository;
    final SolicitudRepository solicitudRepository;

    public UserController(UserRepository userRepository, RolRepository rolRepository, SolicitudRepository solicitudRepository){
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;
        this.solicitudRepository = solicitudRepository;
    }

    @GetMapping(value = "/listar")
    public List<User> listarUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/crear")
    public ResponseEntity<HashMap<String, Object>> crearUser(
            @RequestBody User newUser,
            @RequestParam(value = "fetchId", required = false) boolean fetchId) {
        HashMap<String, Object> responseMap = new HashMap<>();
        userRepository.save(newUser);
        if (fetchId) {
            responseMap.put("id", newUser.getId());
        }
        responseMap.put("estado", "creado");
        return ResponseEntity.status(HttpStatus.CREATED).body(responseMap);
    }
}
