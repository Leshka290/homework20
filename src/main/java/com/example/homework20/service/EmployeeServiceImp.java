package com.example.homework20.service;

import com.example.homework20.model.Employee;
import com.example.homework20.exception.EmployeeAlreadyAddedException;
import com.example.homework20.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImp implements EmployeeService{

    public Map<String, Employee> employeeBookMap;

    public EmployeeServiceImp() {
        this.employeeBookMap = new HashMap<>();
    }
    @Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);

        if (!employeeBookMap.containsKey(employee.getFullName())) {
            employeeBookMap.put(employee.getFullName(), employee);
            return employee;
        } else {
            throw new EmployeeAlreadyAddedException();
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String name = firstName + " " + lastName;

        if (employeeBookMap.containsKey(name)) {
            return employeeBookMap.remove(name);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String name = firstName + " " + lastName;

        if (employeeBookMap.containsKey(name)) {
            return employeeBookMap.get(name);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee getInfoEmployee(String firstName, String lastName) {
        String name = firstName + " " + lastName;

        if (employeeBookMap.containsKey(name)) {
            return employeeBookMap.get(name);
        } else {
            throw new EmployeeNotFoundException();
        }
    }
}
