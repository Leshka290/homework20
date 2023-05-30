package com.example.homework20.service;

import com.example.homework20.exception.WrongEntryException;
import com.example.homework20.model.Employee;
import com.example.homework20.exception.EmployeeAlreadyAddedException;
import com.example.homework20.exception.EmployeeNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeBookMap;

    public EmployeeServiceImpl() {
        this.employeeBookMap = new HashMap<>();
    }


    @Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        validateInput(firstName, lastName);
        
        Employee employee = new Employee(firstName, lastName, department, salary);

        if (!employeeBookMap.containsKey(employee.getFullName())) {
            employeeBookMap.put(employee.getFullName(), employee);
            return employee;
        } else {
            throw new EmployeeAlreadyAddedException();
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {

        if (!employeeBookMap.containsKey(employee.getFullName())) {
            employeeBookMap.put(employee.getFullName(), employee);
            return employee;
        } else {
            throw new EmployeeAlreadyAddedException();
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {

        if (employeeBookMap.containsKey(fullName(firstName, lastName))) {
            return employeeBookMap.remove(fullName(firstName, lastName));
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        if (employeeBookMap.containsKey(fullName(firstName, lastName))) {
            return employeeBookMap.get(fullName(firstName, lastName));
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeBookMap.values();
    }

    private String fullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    private void validateInput(String firstName, String lastName) {
        if(!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) {
            throw new WrongEntryException();
        }
    }
}
