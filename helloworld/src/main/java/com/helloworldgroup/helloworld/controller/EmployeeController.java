package com.helloworldgroup.helloworld.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Employee;
import com.helloworldgroup.helloworld.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody  String requestBody) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(requestBody, Employee.class);
        System.out.println(employee.toString());
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @GetMapping("getAllEmployee")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getListOfEmployee(), HttpStatus.OK);
    }

    @GetMapping("getAllEmployeeGroupByDepartment")
    public ResponseEntity<Map<String, Map<String, Map<String,List<Employee>>>>> getAllEmployeesGroupByDepartment(){
        Map<String, Map<String, Map<String,List<Employee>>>> list = employeeService.getListOfEmployee().stream().
                collect(
                        Collectors.groupingBy(Employee::getGender,
                            Collectors.groupingBy(Employee::getDepartment,
                                    Collectors.groupingBy(Employee::getDesignation))));

        /*Map<String, Map<String, List<Employee>>> multipleFieldsMapList = employeeService.getListOfEmployee().stream()
                .collect(
                        Collectors.groupingBy(Employee::getDesignation,
                                Collectors.groupingBy(Employee::getGender)));*/

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("employeeById")
    public ResponseEntity<Employee> findEmployeeById(@RequestParam Long id){
        return new ResponseEntity(employeeService.findEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("employeeByIdAndName")
    public ResponseEntity<Employee> findEmployeeByIdName(@RequestParam Long id, @RequestParam String name){
        return new ResponseEntity(employeeService.findEmployeeByIdAndName(id, name), HttpStatus.OK);
    }
}
