package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private VehicleType type;

    @Column(length = 50, nullable = false)
    private String registrationNo;

    @Column(length = 50)
    private String make;

    @Column(length = 50)
    private String model;

    private int year;
}
