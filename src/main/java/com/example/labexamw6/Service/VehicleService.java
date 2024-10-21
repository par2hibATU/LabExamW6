package com.example.labexamw6.Service;

import com.example.labexamw6.DTO.Vehicle;
import com.example.labexamw6.Repository.VehicleRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepos vehicleRepos;
    @Autowired
    public VehicleService(VehicleRepos vehicleRepos) {
        this.vehicleRepos = vehicleRepos;
    }

    public Vehicle addVehicle(Vehicle vehicle){
        return vehicleRepos.save(vehicle);
    }

    public List<Vehicle> getAllVehicles(){
        return vehicleRepos.findAll();
    }

    public Optional<Vehicle> getVehicleByRegistration(String registrationNumber){
        return vehicleRepos.findByRegistrationNumber(registrationNumber);
    }

    public Vehicle updateVehicle(String registrationNumber, Vehicle vehicle){
        Optional<Vehicle> queryVehReg = vehicleRepos.findByRegistrationNumber(registrationNumber);
        if(!queryVehReg.isPresent()){
            throw new RuntimeException("Vehicle not Found!");
        }
        Vehicle existingVehicle = queryVehReg.get();
        existingVehicle.setVehicleName(vehicle.getVehicleName());
        existingVehicle.setVehicleType(vehicle.getVehicleType());
        existingVehicle.setRegistrationNumber(vehicle.getRegistrationNumber());
        existingVehicle.setPrice(vehicle.getPrice());
        existingVehicle.setYearOfManufacture(vehicle.getYearOfManufacture());
        existingVehicle.setMileage(vehicle.getMileage());
        return vehicleRepos.save(existingVehicle);
    }
}
