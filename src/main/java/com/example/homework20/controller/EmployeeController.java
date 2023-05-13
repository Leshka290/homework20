package com.example.homework20.controller;

import com.example.homework20.model.Employee;
import com.example.homework20.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
        public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName
            , @RequestParam int department, @RequestParam double salary) {
            return employeeService.addEmployee(firstName, lastName, department, salary);
        }

        @GetMapping("/remove")
        public Employee revomeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
            return employeeService.removeEmployee(firstName, lastName);
        }

        @GetMapping("/find")
        public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
            return employeeService.findEmployee(firstName, lastName);
        }

        @GetMapping("/infoEmployee")
        public Employee getInfoEmployee(@RequestParam String firstName, @RequestParam String lastName) {
            return employeeService.getInfoEmployee(firstName, lastName);
        }
}
