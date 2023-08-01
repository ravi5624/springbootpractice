package com.helloworldgroup.helloworld;

import com.helloworldgroup.helloworld.service.EmployeeService;
import models.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeMockTest {

    @MockBean
    EmployeeService employeeService;

    @Test
    public void testEmployee(){
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setDepartment("IT");
        employee.setGender("Male");
        employee.setEmail("er@ll.com");
        employee.setName("Rohan");


        Mockito.when(employeeService.findEmployeeById(1l)).thenReturn(Optional.of(employee));
        Assert.assertEquals(Optional.of(employee), employeeService.findEmployeeById(1L));
    }

    @Test
    public void testAllEmployee(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1L, "rajehs", "raj@raj.com", "SAP", "ASS CUn", "male"));
        list.add(new Employee(2L, "ram", "raj1@raj.com", "SAP", "ASS IO", "female"));
        list.add(new Employee(3L, "rohit", "raj2@raj.com", "IT", "ASIO", "female"));
        list.add(new Employee(4L, "john", "raj3@raj.com", "CIVIL", "ASpopi", "male"));
        list.add(new Employee(5L, "koli", "raj4@raj.com", "JAVA", "Aewe", "male"));

        Mockito.when(employeeService.getListOfEmployee()).thenReturn(list);

        Assert.assertEquals(list, employeeService.getListOfEmployee());

    }
}
