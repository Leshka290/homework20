package com.example.homework20.controller;

import com.example.homework20.model.Employee;
import com.example.homework20.service.EmployeeBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RequestMapping("/departments")
@RestController
public class EmployeeBookController {

    EmployeeBookService employeeBookService;

    public EmployeeBookController(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }

    @GetMapping("/all")
    public List<Map.Entry<String,Employee>> informationEmployees() {
        return employeeBookService.informationEmployees();
    }

    @GetMapping("/all/dep")
    public Set<Map.Entry<String,Employee>>  informationEmployeesDepartment(@RequestParam int departmentId) {
        return employeeBookService.informationEmployeesDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minEmployeeSalaryDep(@RequestParam("departmentId") int departmentId) {

        return employeeBookService.minEmployeeSalaryDep(departmentId);
    }

    @GetMapping("/max-salary")
    public Employee maxEmployeeSalaryDep(@RequestParam("departmentId") int departmentId) {

        return employeeBookService.maxEmployeeSalaryDep(departmentId);
    }
}
