package com.springboot.major.Boot.dao;

import java.util.List;
import com.springboot.major.Boot.model.Employee;

public interface EmployeeDAO {
    void addEmployee(Employee employee);
    void updateEmployee(Employee employee, int id);
    List<Employee> listEmployees();
    Employee getEmployeeById(int id);
    void removeEmployee(int id);
}
