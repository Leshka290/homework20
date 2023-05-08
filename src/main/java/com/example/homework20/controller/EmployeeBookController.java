package com.example.homework20.controller;

import com.example.homework20.Employee;
import com.example.homework20.EmployeeBook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/employeeBook")
@RestController
public class EmployeeBookController {

    EmployeeBook employeeBook;

    public EmployeeBookController(EmployeeBook employeeBook) {
        this.employeeBook = employeeBook;
    }

    @GetMapping("/add")
    public Employee addEmployee(String firstName, String lastName) {
        return employeeBook.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee revomeEmployee(String firstName, String lastName) {
        return employeeBook.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(String firstName, String lastName) {
        return employeeBook.findEmployee(firstName, lastName);
    }

    @GetMapping("/informationImployees")
    public Map<String, Employee> informationEmployees() {
        return employeeBook.informationEmployees();
    }

    @GetMapping("/infoEmployee")
    public Employee getInfoEmployee(String firstName, String lastName) {
        return employeeBook.getInfoEmployee(firstName, lastName);
    }
}
