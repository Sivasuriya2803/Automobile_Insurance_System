package com.example.demo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.demo.model.RoleType;

import lombok.Data;
@Data

public class UserResponseDTO {
    public int userId;
    public String name;
    public String email;
    public String aadharNumber;
    public String panNumber;
    public String address;
    public LocalDate dob;
    public RoleType roleName;
    public LocalDateTime createdAt;
}
