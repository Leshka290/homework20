package com.example.homework20.service;

import com.example.homework20.model.Employee;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int department, double salary);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Employee getInfoEmployee(String firstName, String lastName);
}
