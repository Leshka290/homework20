package com.example.homework20.service;

import com.example.homework20.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Map<Integer, List<Employee>> informationEmployees();

    Collection<Employee> informationEmployeesDepartment(int departmentId);

    double minEmployeeSalaryDep(int department);

    double maxEmployeeSalaryDep(int department);

    double sumEmployeeSalary(int department);
}
