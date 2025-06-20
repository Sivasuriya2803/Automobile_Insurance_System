package com.example.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.demo.model.PolicyStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class PolicyDto {
	private int policyId;
    private String policyNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal premiumAmount;
    private PolicyStatus status;
    
    public PolicyDto(int policyId, String policyNumber, LocalDate startDate, LocalDate endDate, BigDecimal premiumAmount, PolicyStatus status) {
        this.policyId = policyId;
        this.policyNumber = policyNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.premiumAmount = premiumAmount;
        this.status = status;
    }

}
