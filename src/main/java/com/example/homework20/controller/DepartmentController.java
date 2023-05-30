package com.example.homework20.controller;

import com.example.homework20.model.Employee;
import com.example.homework20.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> informationEmployees() {
        return departmentService.informationEmployees();
    }

    @GetMapping(value = "/{id}/employees")
    public Collection<Employee> informationEmployeesDepartment(@PathVariable int id) {
        return departmentService.informationEmployeesDepartment(id);
    }

    @GetMapping(value = "/{id}/salary/min")
    public double minEmployeeSalaryDep(@PathVariable int id) {

        return departmentService.minEmployeeSalaryDep(id);
    }

    @GetMapping(value = "/{id}/salary/max")
    public double maxEmployeeSalaryDep(@PathVariable int id) {

        return departmentService.maxEmployeeSalaryDep(id);
    }

    @GetMapping(value = "/{id}/salary/sum")
    public double sumEmployeeSalaryDep(@PathVariable int id) {

        return departmentService.sumEmployeeSalary(id);
    }
}
