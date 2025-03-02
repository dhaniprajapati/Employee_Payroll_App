package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeService {
    //dependency injection
    @Autowired
    public EmployeeRepository employeeRepository;
    //save employees
    public EmployeeEntity saveEmployees(EmployeeDTO employee){
        EmployeeEntity emp = new EmployeeEntity();
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        log.info("Saving employee: {}", employee.getName());

        return employeeRepository.save(emp);
    }
    //list of employees
    public List<EmployeeEntity> getAllEmployees(){
        log.info("Getting all employees");
        return employeeRepository.findAll();
    }
    //get employess by id
    public Optional<EmployeeEntity> getEmployeeById(Long id){
        try {
            log.info("Get employee details by id: {}", id);
            return employeeRepository.findById(id);
        } catch (Exception e) {
            log.error("Error finding employee with ID {}", id, e);
            return Optional.empty();
        }
    }
    //delete employees by id
    public boolean deleteEmployee(Long id) {
        // Try block
        try {
            employeeRepository.deleteById(id);
            log.info("Deleted employee with ID: {}", id);
            return true;
        }
        // Catch block
        catch (Exception e) {
            log.error("Error deleting employee with ID: {}", id, e);
            return false;
        }
    }
    //update employees
    public EmployeeEntity updateEmployee(Long id, EmployeeDTO newEmployee){
        try {
            log.info("Updated employee details.");
            Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);
            if (optionalEmployee.isPresent()) {
                EmployeeEntity existingEmployee = optionalEmployee.get();
                existingEmployee.setName(newEmployee.getName());
                existingEmployee.setSalary(newEmployee.getSalary());
                return employeeRepository.save(existingEmployee);
            }
            return null;
        } catch (RuntimeException e) {
            log.error("An unexpected error occurred while updating employee with ID: {}", id, e);
            return null;
        }
    }
}
