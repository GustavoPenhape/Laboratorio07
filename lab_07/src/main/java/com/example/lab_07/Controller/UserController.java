package com.example.lab_07.Controller;

import com.example.lab_07.Entity.User;
import com.example.lab_07.Repository.RolRepository;
import com.example.lab_07.Repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {
    final UserRepository userRepository;
    final RolRepository rolRepository;

    public UserController(UserRepository userRepository, RolRepository rolRepository){
        this.userRepository = userRepository;
        this.rolRepository = rolRepository;}

    @GetMapping(value ="/listar")
    public List<User> listarUsers(){
        return userRepository.findAll();
    }
}