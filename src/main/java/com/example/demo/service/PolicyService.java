package com.example.demo.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PolicyDto;
import com.example.demo.model.Policy;
import com.example.demo.repo.PolicyRepository;
@Service
public class PolicyService {
	 @Autowired
	    private PolicyRepository policyRepository;

	    public Policy addPolicy(Policy policy) {
	        return policyRepository.save(policy);
	    }

	   
	    public PolicyDto getPolicyById(int id) {
	        Policy policy = policyRepository.findById(id)
	                            .orElseThrow(() -> new RuntimeException("Policy not found"));
	        return mapToDTO(policy);
	    }

	    public PolicyDto getPolicyByNumber(String number) {
	        Policy policy = policyRepository.findByPolicyNumber(number)
	                            .orElseThrow(() -> new RuntimeException("Policy number not found"));
	        return mapToDTO(policy);
	    }
	    private PolicyDto mapToDTO(Policy policy) {
	        return new PolicyDto(
	            policy.getPolicyId(),
	            policy.getPolicyNumber(),
	            policy.getStartDate(),
	            policy.getEndDate(),
	            policy.getPremiumAmount(),
	            policy.getStatus()
	        );
	    }
	    public List<PolicyDto> getAllPolicies() {
	        List<Policy> policies = policyRepository.findAll();

	        return policies.stream().map(policy -> {
	            PolicyDto dto = new PolicyDto();
	            dto.setPolicyId(policy.getPolicyId()); 
	            dto.setPolicyNumber(policy.getPolicyNumber());
	            dto.setStartDate(policy.getStartDate());
	            dto.setEndDate(policy.getEndDate());
	            dto.setPremiumAmount(policy.getPremiumAmount());
	            dto.setStatus(policy.getStatus());
	            return dto;
	        }).collect(Collectors.toList());
	    }

	   
}

