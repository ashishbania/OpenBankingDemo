package com.example.demo.OpenBankingDemo.employee.model;

public class Employee {
    private String empId;
    private String name;

    public Employee() {
    }
//constructor with all the fields

    public Employee(String empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

}