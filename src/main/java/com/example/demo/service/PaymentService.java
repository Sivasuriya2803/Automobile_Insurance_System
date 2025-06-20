package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PaymentRequestDTO;
import com.example.demo.dto.PendingPaymentResponseDTO;
import com.example.demo.model.Payment;
import com.example.demo.model.PaymentStatus;
import com.example.demo.repo.PaymentRepository;
import com.example.demo.repo.PolicyRepository;
import com.example.demo.repo.UserRepository;
@Service
public class PaymentService {
	  @Autowired
	    private PaymentRepository paymentRepo;

	    @Autowired
	    private UserRepository userRepo;

	    @Autowired
	    private PolicyRepository policyRepo;

	    public String addPayment(PaymentRequestDTO dto) {
	        Payment payment = new Payment();
	        payment.setUser(userRepo.findById(dto.userId).orElseThrow());
	        payment.setPolicy(policyRepo.findById(dto.policyId).orElseThrow());
	        payment.setAmount(dto.amount);
	        payment.setStatus(PaymentStatus.pending);
	        payment.setPaymentDate(LocalDateTime.now());

	        paymentRepo.save(payment);
	        return "Payment added in pending status";
	    }

	    public List<PendingPaymentResponseDTO> getPendingPaymentsByUser(int userId) {
	    	
	        return paymentRepo.findByUserUserIdAndStatus(userId, PaymentStatus.pending)
	                .stream()
	                .map(payment -> {
	                    PendingPaymentResponseDTO dto = new PendingPaymentResponseDTO();
	                    dto.policyNumber = payment.getPolicy().getPolicyNumber();
	                    dto.amount = payment.getAmount();
	                    return dto;
	                })
	                .toList();
	    }

}
