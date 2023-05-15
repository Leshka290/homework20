package com.example.homework20.service;

import com.example.homework20.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeBookService {

    Map<Integer, List<Employee>> informationEmployees();

    Collection<Employee> informationEmployeesDepartment(int departmentId);

    Employee minEmployeeSalaryDep(int department);

    Employee maxEmployeeSalaryDep(int department);
}
