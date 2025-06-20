package com.example.demo.model;

import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "proposals")
@Data
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proposalId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProposalStatus status;

    private Timestamp submittedAt;
    private double quoteAmount;
    private double finalPremium;

    @ManyToOne
    @JoinColumn(name = "approved_by_officer_id")
    private User approvedByOfficer;

    @ManyToOne
    @JoinColumn(name = "policy_id")
    private Policy policy;

    private Timestamp quoteGeneratedAt;
    private Timestamp activatedAt;
    private Timestamp expiresAt;

    // Getters and Setters
    // (Can be generated using Lombok's @Getter/@Setter or manually)
}
