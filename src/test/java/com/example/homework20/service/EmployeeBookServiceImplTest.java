package com.example.homework20.service;

import com.example.homework20.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collection;
import java.util.Comparator;

import static com.example.homework20.EmployeesList.DEPARTMENT;
import static com.example.homework20.EmployeesList.getEmployees;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeBookServiceImplTest {

    private EmployeeService employeeService;

    private EmployeeBookServiceImpl employeeBookService;

    @BeforeEach
    public void setUp() {
        employeeService = Mockito.mock(EmployeeService.class);
        employeeBookService = new EmployeeBookServiceImpl(employeeService);
    }

    @Test
    public void minEmployeeSalaryDepTest() {
        assertNotNull(employeeBookService);

        Collection<Employee> employees = getEmployees();
        Mockito.when(employeeService.findAll()).thenReturn(employees);

        assertEquals(employeeBookService.minEmployeeSalaryDep(DEPARTMENT)
                , employees.stream().filter(e -> e.getDepartment() == DEPARTMENT)
                        .min(Comparator.comparing(Employee::getSalary)).orElseThrow());
    }

    @Test
    public void maxEmployeeSalaryDepTest() {
        assertNotNull(employeeBookService);

        Collection<Employee> employees = getEmployees();
        Mockito.when(employeeService.findAll()).thenReturn(employees);

        assertEquals(employeeBookService.maxEmployeeSalaryDep(DEPARTMENT)
                , employees.stream().filter(e -> e.getDepartment() == DEPARTMENT)
                        .max(Comparator.comparing(Employee::getSalary)).orElseThrow());
    }
}
