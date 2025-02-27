package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

//UC_3- Ability for the Services Layer to store the Employee Payroll Data
@Service
public class EmployeeService {
    public static final Logger logger= LoggerFactory.getLogger(EmployeeService.class);
    //dependency injection
    @Autowired
    public EmployeeRepository employeeRepository;
    //save employees
    public EmployeeEntity saveEmployees(EmployeeDTO employee){
        EmployeeEntity emp = new EmployeeEntity();
        emp.setName(employee.getName());
        emp.setSalary(employee.getSalary());
        logger.info("Saving employee: {}", employee.getName());

        return employeeRepository.save(emp);
    }
    //list of employees
    public List<EmployeeEntity> getAllEmployees(){
        logger.info("Getting all employees");
        return employeeRepository.findAll();
    }
    //get employess by id
    public Optional<EmployeeEntity> getEmployeeById(Long id){
        logger.info("Get employee details by id: {}", id);
        return employeeRepository.findById(id);
    }
    //delete employees by id
    public void deleteEmployee(Long id){
        logger.info("Delete employee.");
        employeeRepository.deleteById(id);
    }
    //update employees
    public EmployeeEntity updateEmployee(Long id, EmployeeDTO newEmployee){
        logger.info("Updated employee details.");
        Optional<EmployeeEntity> optionalEmployee= employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            EmployeeEntity existingEmployee= optionalEmployee.get();
            existingEmployee.setName(newEmployee.getName());
            existingEmployee.setSalary(newEmployee.getSalary());
            return employeeRepository.save(existingEmployee);
        }
       return null;
    }
}
