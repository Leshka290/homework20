package com.example.homework20;

import com.example.homework20.exception.EmployeeAlreadyAddedException;
import com.example.homework20.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmployeeBookImp implements EmployeeBook {

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        String name = firstName + lastName;

        if (!employeeBookMap.containsKey(name)) {
            employeeBookMap.put(name, employee);
            return employee;
        } else {
            throw new EmployeeAlreadyAddedException();
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String name = firstName + lastName;

        if (employeeBookMap.containsKey(name)) {
            employeeBookMap.remove(name);
            return new Employee(firstName, lastName);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String name = firstName + lastName;

        if (employeeBookMap.containsKey(name)) {
            return employeeBookMap.get(name);
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee getInfoEmployee(String firstName, String lastName) {
        String name = firstName + lastName;

        if (employeeBookMap.containsKey(name)) {
            return employeeBookMap.get(name);
        } else {
            throw new EmployeeNotFoundException();
        }
    }
    @Override
    public Map<String, Employee> informationEmployees() {
        return employeeBookMap;
    }

//    @Override
//    public int howManyDepartments() {
//        int max = Integer.MIN_VALUE;
//
//        for (Map.Entry<String, Employee> employee : employeeBookMap.entrySet()) {
//            max = Math.max(max, employee.getValue().getDepartment());
//        }
//        return max;
//    }
//
//    @Override
//    public double monthlySalary() {
//        double monSalary = 0;
//
//        for (Map.Entry<String, Employee> employee : employeeBookMap.entrySet()) {
//            monSalary += employee.getValue().getSalary();
//        }
//        return monSalary;
//    }
//
//    @Override
//    public double minEmployeeSalary() {
//        double minSalary = Double.MAX_VALUE;
//
//        for (Map.Entry<String, Employee> employee : employeeBookMap.entrySet()) {
//            minSalary = Math.min(minSalary, employee.getValue().getSalary());
//        }
//        return minSalary;
//    }
//
//    @Override
//    public double maxEmployeeSalary() {
//        double maxSalary = Double.MIN_VALUE;
//
//        for (Map.Entry<String, Employee> employee : employeeBookMap.entrySet()) {
//            maxSalary = Math.max(maxSalary, employee.getValue().getSalary());
//        }
//        return maxSalary;
//    }
//
//    @Override
//    public double averageSalary() {
//        double avgSalary = 0;
//
//        avgSalary = monthlySalary() / employeeBookMap.size();
//        return avgSalary;
//    }
//
//    @Override
//    public void indexSalary(int index) {
//        for (Map.Entry<String, Employee> employee : employeeBookMap.entrySet()) {
//            employee.getValue().setSalary(employee.getValue().getSalary()
//                    + (employee.getValue().getSalary() / 100 * index));
//        }
//    }
//
//    @Override
//    public double minEmployeeSalaryDep(int department) {
//        double minSalary = Double.MAX_VALUE;
//
//        for (Map.Entry<String, Employee> employee : employeeBookMap.entrySet()) {
//            if (employee.getValue().getDepartment() == department) {
//                minSalary = Math.min(minSalary, employee.getValue().getSalary());
//            }
//        }
//        return minSalary;
//    }
//
//    @Override
//    public double maxEmployeeSalaryDep(int department) {
//        double maxSalary = Double.MIN_VALUE;
//
//        for (Map.Entry<String, Employee> employee : employeeBookMap.entrySet()) {
//            if (employee.getValue().getDepartment() == department) {
//                maxSalary = Math.max(maxSalary, employee.getValue().getSalary());
//            }
//        }
//        return maxSalary;
//    }
//
//    @Override
//    public double monthlySalaryDep(int department) {
//        double monSalaryDep = 0;
//
//        for (Map.Entry<String, Employee> employee : employeeBookMap.entrySet()) {
//            if (employee.getValue().getDepartment() == department) {
//                monSalaryDep += employee.getValue().getSalary();
//            }
//        }
//        return monSalaryDep;
//    }
//
//    @Override
//    public double averageSalaryDep(int department) {
//        double avgSalary = 0;
//        int numEmployee = 0;
//
//        for (Map.Entry<String, Employee> employee : employeeBookMap.entrySet()) {
//            if (employee.getValue().getDepartment() == department)
//                numEmployee++;
//        }
//        avgSalary = monthlySalaryDep(department) / numEmployee;
//        return avgSalary;
//    }
//
//    @Override
//    public void indexSalaryDep(int index, int department) {
//        for (Map.Entry<String, Employee> employee : employeeBookMap.entrySet()) {
//            if (employee.getValue().getDepartment() == department) {
//                employee.getValue().setSalary(employee.getValue().getSalary()
//                        + (employee.getValue().getSalary() / 100 * index));
//            }
//        }
//    }
}
