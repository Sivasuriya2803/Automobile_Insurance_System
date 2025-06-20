package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId; // ✅ This is your identifier

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    private LocalDate dob;

    @Column(length = 12)
    private String aadharNumber;

    @Column(length = 10)
    private String panNumber;

    @Lob
    private String address;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
