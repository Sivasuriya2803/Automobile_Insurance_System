package com.example.demo.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProposalRequestDTO;
import com.example.demo.dto.ProposalResponseDTO;
import com.example.demo.model.Proposal;
import com.example.demo.model.ProposalStatus;
import com.example.demo.repo.ProposalRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.repo.VehicleRepository;
@Service
public class ProposalService {


    @Autowired
    private ProposalRepository proposalRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private VehicleRepository vehicleRepo;

    public String addProposal(ProposalRequestDTO dto) {
        Proposal proposal = new Proposal();
        proposal.setUser(userRepo.findById(dto.userId).orElseThrow());
        proposal.setVehicle(vehicleRepo.findById(dto.vehicleId).orElseThrow());
        proposal.setQuoteAmount(dto.quoteAmount);
        proposal.setFinalPremium(dto.finalPremium);
        proposal.setStatus(ProposalStatus.PROPOSAL_SUBMITTED);
        proposal.setSubmittedAt(new Timestamp(System.currentTimeMillis()));
        proposalRepo.save(proposal);
        return "Proposal submitted successfully";
    }

    public List<ProposalResponseDTO> getProposalsByUser(int userId) {
        return proposalRepo.findByUserUserId(userId).stream().map(this::mapToDTO).toList();
    }
    public List<ProposalResponseDTO> getPendingProposalsByUser(int userId) {
        return proposalRepo.findByUserUserIdAndStatus(userId, ProposalStatus.QUOTE_GENERATED)
                           .stream().map(this::mapToDTO).toList();
    }

    private ProposalResponseDTO mapToDTO(Proposal p) {
        ProposalResponseDTO dto = new ProposalResponseDTO();
        dto.proposalId = p.getProposalId();
        dto.userId = p.getUser().getUserId();
        dto.vehicleId = p.getVehicle().getVehicleId();
        dto.status = p.getStatus().name();
        dto.submittedAt = p.getSubmittedAt();
        dto.quoteAmount = p.getQuoteAmount();
        dto.finalPremium = p.getFinalPremium();
        return dto;
    }

}
