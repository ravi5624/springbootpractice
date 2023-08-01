package com.helloworldgroup.helloworld.service;

import com.helloworldgroup.helloworld.EmployeeRepository.EmployeeRepo;
import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> getListOfEmployee(){
        return employeeRepo.findAll();
    }

    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Optional<Employee> findEmployeeById(Long id){
        return employeeRepo.findById(id);
    }

    public Optional<Employee> findEmployeeByIdAndName(Long id, String name){
        return employeeRepo.findByIdAndName(id, name);
    }



}
