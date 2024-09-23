package com.springboot.major.Boot.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.major.Boot.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        session.persist(employee);
        session.beginTransaction().commit();
        
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee, int id) {
        Session session = sessionFactory.openSession();
        Employee existingEmployee = session.get(Employee.class, id);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setAge(employee.getAge());
            existingEmployee.setSalary(employee.getSalary());
            
            session.update(existingEmployee);
            session.beginTransaction().commit();
        }
    }

    @Override
    @Transactional
    public List<Employee> listEmployees() {
        Session session = sessionFactory.openSession();
        return session.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.openSession();
        return session.get(Employee.class, id);
    }

    @Override
    @Transactional
    public void removeEmployee(int id) {
        Session session = sessionFactory.openSession();
        Employee employee = session.get(Employee.class, id);
        if (employee != null) {
            session.delete(employee);
            session.beginTransaction().commit();
            
        }
    }
}
