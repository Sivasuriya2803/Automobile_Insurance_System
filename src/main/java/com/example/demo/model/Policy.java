package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "policy")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Column(unique = true, nullable = false)
    private String policyNumber;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(precision = 10, scale = 2)
    private BigDecimal premiumAmount;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private PolicyStatus status;
}
