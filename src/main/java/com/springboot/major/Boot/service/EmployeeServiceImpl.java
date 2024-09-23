package com.springboot.major.Boot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import com.springboot.major.Boot.dao.EmployeeDAO;
import com.springboot.major.Boot.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee, int id) {
        employeeDAO.updateEmployee(employee, id);
    }

    @Override
    @Transactional
    public List<Employee> listEmployees() {
        return employeeDAO.listEmployees();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void removeEmployee(int id) {
        employeeDAO.removeEmployee(id);
    }
}
