package com.example.demo.OpenBankingDemo.employee.service;

import com.example.demo.OpenBankingDemo.employee.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    public Employee createEmployee(Employee employee) {
        Employee emp = new Employee();
        emp.setName(employee.getName());
        emp.setEmpId(employee.getEmpId());
        return emp;
    }
    }

