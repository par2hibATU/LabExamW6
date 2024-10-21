package com.example.labexamw6.Controller;

import com.example.labexamw6.DTO.Vehicle;
import com.example.labexamw6.Repository.VehicleRepos;
import com.example.labexamw6.Service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;
    private final VehicleRepos vehicleRepos;
    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleRepos vehicleRepos) {
        this.vehicleService = vehicleService;
        this.vehicleRepos = vehicleRepos;
    }



    @PostMapping
    public ResponseEntity<Vehicle> addVehicle(@Valid @RequestBody Vehicle vehicle){
        Vehicle registeredVehicle = vehicleService.addVehicle(vehicle);
        return ResponseEntity.ok(registeredVehicle);
    }

    @GetMapping("/registration-number/{registrationNumber}")
    public ResponseEntity<Vehicle> getVehicleByRegistrationNumber(@Valid @PathVariable String registrationNumber){
        Optional<Vehicle> queryVehicle = vehicleService.getVehicleByRegistration(registrationNumber);
        Vehicle existingVeh = queryVehicle.get();
        if(queryVehicle.isPresent()){
            return ResponseEntity.ok(existingVeh);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{registrationNumber}")
    public ResponseEntity<Vehicle> updateVehicle(@Valid @PathVariable String registrationNumber, @RequestBody Vehicle vehicle){
        try{
            Vehicle updatedVehicle = vehicleService.updateVehicle(registrationNumber, vehicle);
            return ResponseEntity.ok(updatedVehicle);
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
