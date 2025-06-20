package com.example.demo.repo;

import com.example.demo.model.Role;
import com.example.demo.model.RoleType;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	 Optional<Role> findByRoleName(RoleType roleName);
}
