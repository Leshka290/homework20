package com.example.homework20.service;

import com.example.homework20.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface EmployeeBookService {

    List<Map.Entry<String,Employee>> informationEmployees();
    Set<Map.Entry<String,Employee>> informationEmployeesDepartment(int departmentId);
    Employee minEmployeeSalaryDep(int department);
    Employee maxEmployeeSalaryDep(int department);
}
