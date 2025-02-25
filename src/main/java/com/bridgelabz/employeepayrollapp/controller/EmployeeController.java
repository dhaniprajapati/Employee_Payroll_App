package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    //UC_1
    @Autowired
    public EmployeeService employeeService;
    @PostMapping
    public EmployeeEntity addEmployees(@RequestBody EmployeeEntity employee){
        return employeeService.saveEmployees(employee);
    }
    @GetMapping
    public List<EmployeeEntity> getEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Optional<EmployeeEntity> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
    @PutMapping("/{id}")
    public EmployeeEntity updateEmployee(@PathVariable Long id, @RequestBody EmployeeEntity newEmployee){
        return employeeService.updateEmployee(id, newEmployee);
    }

}
