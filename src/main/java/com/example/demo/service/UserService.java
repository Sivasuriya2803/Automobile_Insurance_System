package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequestDTO;
import com.example.demo.dto.UserResponseDTO;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repo.RoleRepository;
import com.example.demo.repo.UserRepository;
@Service

public class UserService {
	   @Autowired
	    private UserRepository userRepo;

	    @Autowired
	    private RoleRepository roleRepo;

	    public String addUser(UserRequestDTO dto) {
	        Role role = roleRepo.findById(dto.roleId)
	                .orElseThrow(() -> new RuntimeException("Invalid role"));

	        User user = new User();
	        user.setName(dto.name);
	        user.setEmail(dto.email);
	        user.setPassword(dto.password);
	        user.setDob(dto.dob);
	        user.setAadharNumber(dto.aadharNumber);
	        user.setPanNumber(dto.panNumber);
	        user.setAddress(dto.address);
	        user.setRole(role);

	        userRepo.save(user);
	        return "User added";
	    }

	    public List<UserResponseDTO> getAllUsers() {
	        List<User> users = userRepo.findAll();
	        return users.stream().map(u -> {
	            UserResponseDTO dto = new UserResponseDTO();
	            dto.userId = u.getUserId();
	            dto.name = u.getName();
	            dto.email = u.getEmail();
	            dto.aadharNumber = u.getAadharNumber();
	            dto.panNumber = u.getPanNumber();
	            dto.dob = u.getDob();
	            dto.address = u.getAddress();
	            dto.roleName = u.getRole().getRoleName();
	            dto.createdAt = u.getCreatedAt();
	            return dto;
	        }).collect(Collectors.toList());
	    }

}
