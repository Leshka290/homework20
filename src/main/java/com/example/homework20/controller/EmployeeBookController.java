package com.example.homework20.controller;

import com.example.homework20.model.Employee;
import com.example.homework20.service.EmployeeBookService;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/employees")
//    public Map<Integer, List<Employee>> informationEmployees() {
//        return employeeBookService.informationEmployees();
//    }
//
//    @GetMapping(value = "/{id}/employees")
//    public Collection<Employee> informationEmployeesDepartment(@PathVariable int id) {
//        return employeeBookService.informationEmployeesDepartment(id);
//    }

    @GetMapping(value = "/{id}/salary/minEmployee")
    public Employee minEmployeeSalaryDep(@PathVariable int id) {

        return employeeBookService.minEmployeeSalaryDep(id);
    }

    @GetMapping(value = "/{id}/salary/maxEmployee")
    public Employee maxEmployeeSalaryDep(@PathVariable int id) {

        return employeeBookService.maxEmployeeSalaryDep(id);
    }

}
