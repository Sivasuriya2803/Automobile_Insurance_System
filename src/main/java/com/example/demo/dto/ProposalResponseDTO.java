package com.example.demo.dto;
import java.sql.Timestamp;

import lombok.Data;
@Data
public class ProposalResponseDTO {
    public int proposalId;
    public int userId;
    public int vehicleId;
    public String status;
    public Timestamp submittedAt;
    public double quoteAmount;
    public double finalPremium;
}

