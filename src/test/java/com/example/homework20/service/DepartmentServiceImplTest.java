package com.example.homework20.service;

import com.example.homework20.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.homework20.EmployeesList.DEPARTMENT;
import static com.example.homework20.EmployeesList.getEmployees;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class DepartmentServiceImplTest {

    private EmployeeService employeeService;

    private DepartmentServiceImpl departmentService;

    @BeforeEach
    public void setUp() {
        employeeService = Mockito.mock(EmployeeService.class);
        departmentService = new DepartmentServiceImpl(employeeService);
    }

    @Test
    public void informationEmployeesDepartmentTest() {
        assertNotNull(departmentService);

        Collection<Employee> employees = getEmployees();
        when(employeeService.findAll()).thenReturn(employees);

        Collection<Employee> filterEmployees = employees.stream().filter(e -> e.getDepartment() == DEPARTMENT)
                .collect(Collectors.toList());
        assertEquals(departmentService.informationEmployeesDepartment(DEPARTMENT), filterEmployees);
    }

    @Test
    public void informationEmployeesTest() {
        Map<Integer, List<Employee>> employees = getEmployees().stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .collect(Collectors.groupingBy(Employee::getDepartment));
        when(employeeService.findAll()).thenReturn(getEmployees());

        assertEquals(departmentService.informationEmployees(), employees);
    }

    @Test
    public void minEmployeeSalaryDepTest() {
        Collection<Employee> employees = getEmployees();
        when(employeeService.findAll()).thenReturn(employees);

        assertEquals(departmentService.minEmployeeSalaryDep(DEPARTMENT)
                , employees.stream().filter(e -> e.getDepartment() == DEPARTMENT)
                        .min(Comparator.comparing(Employee::getSalary)).get().getSalary());
    }

    @Test
    public void maxEmployeeSalaryDepTest() {
        Collection<Employee> employees = getEmployees();
        when(employeeService.findAll()).thenReturn(employees);

        assertEquals(departmentService.maxEmployeeSalaryDep(DEPARTMENT)
                , employees.stream().filter(e -> e.getDepartment() == DEPARTMENT)
                                .max(Comparator.comparing(Employee::getSalary)).get().getSalary());
    }

    @Test
    public void sumEmployeeSalaryDepTest() {
        Collection<Employee> employees = getEmployees();
        when(employeeService.findAll()).thenReturn(employees);

        assertEquals(departmentService.sumEmployeeSalary(DEPARTMENT)
                , employees.stream().filter(e -> e.getDepartment() == DEPARTMENT)
                        .mapToDouble(Employee::getSalary).sum());
    }
}
