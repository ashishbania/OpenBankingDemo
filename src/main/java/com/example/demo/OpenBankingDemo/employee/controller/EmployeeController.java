package com.example.demo.OpenBankingDemo.employee.controller;

import com.example.demo.OpenBankingDemo.employee.model.Employee;
import com.example.demo.OpenBankingDemo.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee){
         return employeeService.createEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployee(){
        return Arrays.asList(
                new Employee("123",
                        "Ashish")
        );
    }

}
