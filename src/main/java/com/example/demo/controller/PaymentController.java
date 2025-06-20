package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.PaymentRequestDTO;
import com.example.demo.dto.PendingPaymentResponseDTO;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity<String> addPayment(@RequestBody PaymentRequestDTO dto) {
        return ResponseEntity.ok(paymentService.addPayment(dto));
    }

    @GetMapping("/pending/{userId}")
    public ResponseEntity<List<PendingPaymentResponseDTO>> getPendingPayments(@PathVariable int userId) {
        return ResponseEntity.ok(paymentService.getPendingPaymentsByUser(userId));
    }
}