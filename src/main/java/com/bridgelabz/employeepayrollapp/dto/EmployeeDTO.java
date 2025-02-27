package com.bridgelabz.employeepayrollapp.dto;

import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private String name;
    private double salary;

    public EmployeeDTO(EmployeeEntity entity) {
        this.name = entity.getName();
        this.salary = entity.getSalary();
    }
}
