package com.example.demo.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String dob; 
    private String aadharNumber;
    private String panNumber;
    private String address;
}
