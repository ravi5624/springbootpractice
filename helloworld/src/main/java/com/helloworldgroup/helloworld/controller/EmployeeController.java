package com.helloworldgroup.helloworld.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Employee;
import com.helloworldgroup.helloworld.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
        return getAllEmployeesList(1, "firstName", "asc", model);
    }

    private String getAllEmployeesList(int i, String firstName, String asc, Model model) {
        model.addAttribute("listEmployees", employeeService.getListOfEmployee());
        return "index";
    }


    @GetMapping("newEmployeeForm")
    public String newEmpForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }


    @GetMapping("/updateEmployeeForm/{id}")
    public String updateEmployeeForm(@PathVariable(value = "id") long id, Model model) {
        // create model attribute to bind form data
        Employee employee = employeeService.findEmployeeById(id).get();
        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @PostMapping("saveEmployee")
    public String saveEmployee(@ModelAttribute("employee")  Employee employee) {
        employeeService.addEmployee(employee);
        return "redirect:/";
    }

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

    @GetMapping("deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }

}
