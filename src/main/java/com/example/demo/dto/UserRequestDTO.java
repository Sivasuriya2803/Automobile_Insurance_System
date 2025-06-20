package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserRequestDTO {
    public String name;
    public String email;
    public String password;
    public String aadharNumber;
    public String panNumber;
    public String address;
    public LocalDate dob;
    public int roleId;
}

