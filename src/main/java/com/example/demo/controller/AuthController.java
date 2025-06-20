package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.User;
import com.example.demo.model.Role;
import com.example.demo.model.RoleType;
import com.example.demo.repo.RoleRepository;
import com.example.demo.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;
   

    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest req) {
        if (userRepo.findByEmail(req.getEmail()).isPresent()) {
            return "Email already registered";
        }

        Role userRole = roleRepo.findByRoleName(RoleType.User) 
            .orElseThrow(() -> new RuntimeException("Default role not found"));

        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        user.setPassword(req.getPassword());
        user.setDob(LocalDate.parse(req.getDob()));
        user.setAadharNumber(req.getAadharNumber());
        user.setPanNumber(req.getPanNumber());
        user.setAddress(req.getAddress());
        user.setRole(userRole);

        userRepo.save(user); 
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest req) {
        Optional<User> userOpt = userRepo.findByEmail(req.getEmail());

        if (userOpt.isPresent() && userOpt.get().getPassword().equals(req.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid email or password";
        }
    }
}
