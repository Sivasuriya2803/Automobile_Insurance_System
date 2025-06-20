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

import com.example.demo.dto.ProposalRequestDTO;
import com.example.demo.dto.ProposalResponseDTO;
import com.example.demo.service.ProposalService;

@RestController
@RequestMapping("/proposal")
public class ProposalController {

	 @Autowired
	    private ProposalService proposalService;

	    @PostMapping("/add")
	    public ResponseEntity<String> addProposal(@RequestBody ProposalRequestDTO dto) {
	        return ResponseEntity.ok(proposalService.addProposal(dto));
	    }

	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<ProposalResponseDTO>> getProposals(@PathVariable int userId) {
	        return ResponseEntity.ok(proposalService.getProposalsByUser(userId));
	    }

	    @GetMapping("/pending/{userId}")
	    public ResponseEntity<List<ProposalResponseDTO>> getPending(@PathVariable int userId) {
	        return ResponseEntity.ok(proposalService.getPendingProposalsByUser(userId));
	    }
}
