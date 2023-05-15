package com.example.homework20.controller;

import com.example.homework20.model.Employee;
import com.example.homework20.service.EmployeeBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RequestMapping("/departments")
@RestController
public class EmployeeBookController {

    private final EmployeeBookService employeeBookService;

    public EmployeeBookController(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> informationEmployees() {
        return employeeBookService.informationEmployees();
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    public Collection<Employee> informationEmployeesDepartment(@RequestParam int departmentId) {
        return employeeBookService.informationEmployeesDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minEmployeeSalaryDep(@RequestParam int departmentId) {

        return employeeBookService.minEmployeeSalaryDep(departmentId);
    }

    @GetMapping("/max-salary")
    public Employee maxEmployeeSalaryDep(@RequestParam int departmentId) {

        return employeeBookService.maxEmployeeSalaryDep(departmentId);
    }
}
