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

import com.example.demo.dto.PolicyDto;
import com.example.demo.model.Policy;
import com.example.demo.service.PolicyService;
@RestController
@RequestMapping("/policy")
public class PolicyController {
    @Autowired
    private PolicyService policyService;

    @PostMapping("/add")
    public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy) {
        return ResponseEntity.ok(policyService.addPolicy(policy));
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<PolicyDto> getPolicyById(@PathVariable int id) {
        return ResponseEntity.ok(policyService.getPolicyById(id));
    }

    @GetMapping("/number/{policyNumber}")
    public ResponseEntity<PolicyDto> getPolicyByNumber(@PathVariable String policyNumber) {
        return ResponseEntity.ok(policyService.getPolicyByNumber(policyNumber));
    }
    
    @GetMapping("/policies")
    public ResponseEntity<List<PolicyDto>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }
}
