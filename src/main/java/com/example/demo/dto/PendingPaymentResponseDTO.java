package com.example.demo.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class PendingPaymentResponseDTO {
	public String policyNumber;
    public BigDecimal amount;

}
