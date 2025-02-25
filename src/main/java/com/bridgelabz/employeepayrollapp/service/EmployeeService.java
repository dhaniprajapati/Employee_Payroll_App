package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.entity.EmployeeEntity;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    public static final Logger logger= LoggerFactory.getLogger(EmployeeService.class);
    //dependency injection
    @Autowired
    public EmployeeRepository employeeRepository;
    //save employees
    public EmployeeEntity saveEmployees(EmployeeEntity employee){
        return employeeRepository.save(employee);
    }
    //list of employees
    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }
    //
    public Optional<EmployeeEntity> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity newEmployee){
        Optional<EmployeeEntity> optionalEmployee= employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            EmployeeEntity existingEmployee= optionalEmployee.get();
            existingEmployee.setName(newEmployee.getName());
            existingEmployee.setDepartment(newEmployee.getDepartment());
            existingEmployee.setSalary(newEmployee.getSalary());
            return employeeRepository.save(existingEmployee);
        }
        else{
            newEmployee.setId(id);
            return employeeRepository.save(newEmployee);
        }
    }
}
