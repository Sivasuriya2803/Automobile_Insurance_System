package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	  @Autowired
	    private UserService userService;

	    @PostMapping("/add")
	    public ResponseEntity<String> addUser(@RequestBody UserRequestDTO dto) {
	        return ResponseEntity.ok(userService.addUser(dto));
	    }

	    @GetMapping("/show")
	    public ResponseEntity<List<UserResponseDTO>> getAll() {
	        return ResponseEntity.ok(userService.getAllUsers());
	    }
}
