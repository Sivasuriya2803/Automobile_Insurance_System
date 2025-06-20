package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Proposal;
import com.example.demo.model.ProposalStatus;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Integer> {

    List<Proposal> findByUserUserId(int userId);

    List<Proposal> findByUserUserIdAndStatus(int userId, ProposalStatus status);
}

