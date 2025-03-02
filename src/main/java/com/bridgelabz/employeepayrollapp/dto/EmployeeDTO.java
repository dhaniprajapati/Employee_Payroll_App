package com.bridgelabz.employeepayrollapp.dto;

import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    private String name;
    @Min(value = 10000, message = "Salary should be minimum 10,000")
    private double salary;

    public EmployeeDTO(EmployeeEntity entity) {
        this.name = entity.getName();
        this.salary = entity.getSalary();
    }
}
