package com.example.homework20;

import com.example.homework20.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeesList {

    public static Collection<Employee> getEmployees() {
        return new ArrayList<>(List.of(
                new Employee("Alex", "Ivanov", 2, 3000),
                new Employee("Mary", "Ivanova", 1, 2000),
                new Employee("Sam", "Petrov", 3, 5000),
                new Employee("Max", "Sidorov", 2, 7000),
                new Employee("Petr", "Kovalev", 1, 4000)
        ));
    }

    public static int DEPARTMENT = 1;
}
