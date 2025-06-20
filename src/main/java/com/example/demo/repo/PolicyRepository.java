package com.example.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Policy;
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {
	Optional<Policy> findById(Integer id);
    Optional<Policy> findByPolicyNumber(String policyNumber);
}
