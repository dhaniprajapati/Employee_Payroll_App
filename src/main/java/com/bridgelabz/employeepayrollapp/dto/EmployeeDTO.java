package com.bridgelabz.employeepayrollapp.dto;

import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;

public class EmployeeDTO {
    private String name;
    private double salary;

    public EmployeeDTO() {}

    public EmployeeDTO(EmployeeEntity entity) {
        this.name = entity.getName();
        this.salary = entity.getSalary();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
