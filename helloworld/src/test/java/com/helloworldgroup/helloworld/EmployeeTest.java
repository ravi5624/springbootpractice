package com.helloworldgroup.helloworld;

import com.helloworldgroup.helloworld.service.EmployeeService;
import models.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeTest {
    @Test
    void contextLoads() {
    }

    @Autowired
    EmployeeService employeeService;

    @Test
    public void testAddEmployee(){
        System.out.println(employeeService.addEmployee(new Employee(301L,"kamiyo","kamiyi@chitu.com", "ME", "teacher", "male")).toString());
    }

    @Test
    public void getAddEmployee(){
        System.out.println(employeeService.getListOfEmployee().toString());
    }

    @Test
    public void getAddEmployeeByID(){
        System.out.println(employeeService.findEmployeeById(204L).toString());
    }

    @Test
    public void getAddEmployeeByIDAndName(){
        System.out.println(employeeService.findEmployeeByIdAndName(252L, "Kamiyo").toString());
    }


}
