package com.example.homework20.service;

import com.example.homework20.exception.EmployeeNotFoundException;
import com.example.homework20.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeBookServiceImp implements EmployeeBookService {

    private final EmployeeService employeeService;

    public EmployeeBookServiceImp(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Map<Integer, List<Employee>> informationEmployees() {
        return employeeService.findAll().stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Override
    public Collection<Employee> informationEmployeesDepartment(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Employee minEmployeeSalaryDep(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee maxEmployeeSalaryDep(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }
}
