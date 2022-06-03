package com.tackedev.springboot.crmrestdemo.dao;

import com.tackedev.springboot.crmrestdemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for EntityManager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Session currentSession =  entityManager.unwrap(Session.class);

        Query<Employee> query = currentSession.createQuery("FROM Employee", Employee.class);

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {

        Session session = entityManager.unwrap(Session.class);

        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void save(Employee employee) {

        Session session = entityManager.unwrap(Session.class);

        // if id = 0 then insert, else update
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {

        Session session = entityManager.unwrap(Session.class);

        Query query = session.createQuery("DELETE FROM Employee WHERE id=:employeeId");
        query.setParameter("employeeId", id);

        query.executeUpdate();
    }

}
