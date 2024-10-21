package com.example.labexamw6.Repository;

import com.example.labexamw6.DTO.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface VehicleRepos extends MongoRepository<Vehicle, String> {
    Optional<Vehicle> findByRegistrationNumber(String registrationNumber);
}
