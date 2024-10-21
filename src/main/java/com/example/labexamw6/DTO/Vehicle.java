package com.example.labexamw6.DTO;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "LabExamW6")
public class Vehicle {
    @Id
    @Valid
    private String id;
    @NotNull(message = "Must not be empty...")
    private String vehicleName;
    @NotNull(message = "Must not be empty and you have to select one of the options: Car/Truck/Motorcycle/Bus")
    private String vehicleType;
    @UniqueElements(message = "Registration Number should be Unique")
    @Pattern(regexp = "[[A-Z][A-Z]0-9]")
    private String registrationNumber;
    @Min(value = 0, message = "Price must be greater than 0")
    private double price;

    @Min(1886) @Max(2024)
    private int yearOfManufacture;
    @Min(value = 0, message = "Not allowed to go down to 0")
    private int mileage;
}
