package com.tackedev.springboot.crmrestdemo.service;

import com.tackedev.springboot.crmrestdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    void save(Employee employee);

    void deleteById(int id);
}
