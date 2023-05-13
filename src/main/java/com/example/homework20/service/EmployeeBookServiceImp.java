package com.example.homework20.service;

import com.example.homework20.model.Employee;
import com.example.homework20.service.EmployeeServiceImp;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeBookServiceImp implements EmployeeBookService {

    EmployeeServiceImp employeeServiceImp;

    public EmployeeBookServiceImp(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @Override
    public List<Map.Entry<String, Employee>> informationEmployees() {

        return employeeServiceImp.employeeBookMap.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(e -> e.getValue().getDepartment()))
                .collect(Collectors.toList());
    }

    @Override
    public Set<Map.Entry<String, Employee>> informationEmployeesDepartment(int department) {
        return employeeServiceImp.employeeBookMap.entrySet()
                .stream()
                .filter(e -> e.getValue().getDepartment() == department)
                .collect(Collectors.toSet());
    }

    @Override
    public Employee minEmployeeSalaryDep(int department) {
        return employeeServiceImp.employeeBookMap.entrySet()
                .stream()
                .filter(e -> e.getValue().getDepartment() == department)
                .min(Comparator.comparingInt(e -> (int) e.getValue().getSalary()))
                .get().getValue();
    }

    @Override
    public Employee maxEmployeeSalaryDep(int department) {
        return employeeServiceImp.employeeBookMap.entrySet()
                .stream()
                .filter(e -> e.getValue().getDepartment() == department)
                .max(Comparator.comparingInt(e -> (int) e.getValue().getSalary()))
                .get().getValue();
    }
}
