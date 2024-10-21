package com.example.labexamw6.DTO;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "vehicles")
public class Vehicle {
    @Id
    @Valid
    private String id;
    @NotNull(message = "Must not be empty...")
    private String vehicleName;
    @NotNull(message = "Must not be empty and you have to select one of the options: Car/Truck/Motorcycle/Bus")
    private String vehicleType;
    private String registrationNumber;
    @Min(value = 0, message = "Price must be greater than 0")
    private double price;
    @Min(value = 1886, message = "Older than 1886 is not allowed trade here")
    @Max(value = 2024, message = "Welcome onBoard")
    private int yearOfManufacture;
    @Min(value = 0, message = "Not allowed to go down to 0")
    private int mileage;
}
