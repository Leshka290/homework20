package com.example.homework20.service;

import com.example.homework20.exception.EmployeeNotFoundException;
import com.example.homework20.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
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
    public double minEmployeeSalaryDep(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new).getSalary();
    }

    @Override
    public double maxEmployeeSalaryDep(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new).getSalary();
    }

    @Override
    public double sumEmployeeSalary(int department) {
        return employeeService.findAll().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary).sum();
    }
}
