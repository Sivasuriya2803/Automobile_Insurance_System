package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Vehicle;
import com.example.demo.model.VehicleType;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    List<Vehicle> findByUserUserId(int userId);
    List<Vehicle> findByType(VehicleType type);
}

