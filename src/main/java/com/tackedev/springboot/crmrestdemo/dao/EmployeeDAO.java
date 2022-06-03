package com.tackedev.springboot.crmrestdemo.dao;

import com.tackedev.springboot.crmrestdemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);

}
