package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<?> addEmployees(@RequestBody EmployeeDTO employee){
        log.info("Adding a new employee: {}", employee.getName());
        EmployeeEntity saveEmployee= employeeService.saveEmployees(employee);
        return ResponseEntity.ok(new EmployeeDTO(saveEmployee));
    }
    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(){
        log.info("Get all employee details");
        List<EmployeeEntity> getEmployees=  employeeService.getAllEmployees();
        List<EmployeeDTO> getEmployeeDetails= new ArrayList<>();
        for(EmployeeEntity entity: getEmployees){
            getEmployeeDetails.add(new EmployeeDTO(entity));
        }
        return ResponseEntity.ok(getEmployees);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
        log.info("Get employee details by id: {}", id);
        Optional<EmployeeEntity> getEmployee = employeeService.getEmployeeById(id);
        if(getEmployee.isPresent()){
            return ResponseEntity.ok(new EmployeeDTO(getEmployee.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDTO> deleteEmployee(@PathVariable Long id){
        log.info("Delete employee.");
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){
        log.info("Updated employee details.");
        EmployeeEntity updateEmployee= employeeService.updateEmployee(id, employeeDTO);
        return ResponseEntity.ok(new EmployeeDTO(updateEmployee));
    }
}
