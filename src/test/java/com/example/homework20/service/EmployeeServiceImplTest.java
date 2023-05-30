package com.example.homework20.service;

import com.example.homework20.exception.EmployeeAlreadyAddedException;
import com.example.homework20.exception.EmployeeNotFoundException;
import com.example.homework20.model.Employee;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    private final Employee employee = new Employee("Ivan", "Ivanov", 1, 2000);
    private final Employee employee1 = new Employee("Mary", "Ivanova", 2, 3000);
    private final Map<String, Employee> employeeBookMap = new HashMap<>();

    @Test
    public void addEmployeeTest() {
        employeeBookMap.put(employee.getFullName(), employee);
        employeeService.addEmployee(employee);

        assertEquals(employeeBookMap.get("Ivan Ivanov")
                , employeeService.findEmployee(employee.getFirstName(), employee.getLastName()));
        assertTrue(employeeService.findAll().contains(employee));
    }

    @Test
    public void addEmployeeAlreadyAddedTest() {
        employeeBookMap.put(employee.getFullName(), employee);
        employeeService.addEmployee(employee);

        try {
            assertNull(employeeService.addEmployee(employee));
        } catch (EmployeeAlreadyAddedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sizeChangeTest() {
        employeeService.addEmployee(employee);
        employeeService.addEmployee(employee1);

        assertEquals(2, employeeService.findAll().size());
        employeeService.removeEmployee("Ivan", "Ivanov");
        assertEquals(1, employeeService.findAll().size());
    }

    @Test
    public void removeEmployeeTest() {

        employeeService.addEmployee(employee);
        employeeService.removeEmployee("Ivan", "Ivanov");
        assertTrue(employeeService.findAll().isEmpty());
    }

    @Test
    public void removeEmployeeIndexOutTest() {
        try {
            assertNull(employeeService.removeEmployee("Ivan", "Ivanov"));
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void notFoundEmployeeTest() {
        try {
            assertNull(employeeService.findEmployee("Ivan", "Ivanov"));
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findEmployeeTest() {
        employeeService.addEmployee(employee);

        assertEquals(employeeService.findEmployee("Ivan", "Ivanov"), employee);
    }

    @Test
    public void findAllTest() {
        employeeService.addEmployee(employee);
        employeeService.addEmployee(employee1);

        employeeBookMap.put(employee.getFullName(), employee);
        employeeBookMap.put(employee1.getFullName(), employee1);

        assertTrue(employeeBookMap.values().containsAll(employeeService.findAll()));
    }
}
