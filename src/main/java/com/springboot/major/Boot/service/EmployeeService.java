package com.springboot.major.Boot.service;

import java.util.List;
import com.springboot.major.Boot.model.Employee;

public interface EmployeeService {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee, int id);
    List<Employee> listEmployees();
    Employee getEmployeeById(int id);
    void removeEmployee(int id);
}
