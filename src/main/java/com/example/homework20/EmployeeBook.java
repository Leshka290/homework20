package com.example.homework20;

import java.util.HashMap;
import java.util.Map;


public interface EmployeeBook {

    Map<String, Employee> employeeBookMap = new HashMap<>();
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    Map<String, Employee> informationEmployees();
    Employee getInfoEmployee(String firstName, String lastName);

//    int howManyDepartments();
//    double monthlySalary();
//    double minEmployeeSalary();
//    double maxEmployeeSalary();
//    double averageSalary();
//    void indexSalary(int index);
//    double minEmployeeSalaryDep(int department);
//    double maxEmployeeSalaryDep(int department);
//    double monthlySalaryDep(int department);
//    double averageSalaryDep(int department);
//    void indexSalaryDep(int index, int department);
}
