package com.example.demo.dto;

import java.math.BigDecimal;

import lombok.Data;
@Data
public class PaymentRequestDTO {
	 public int userId;
	    public int policyId;
	    public BigDecimal amount;

}
