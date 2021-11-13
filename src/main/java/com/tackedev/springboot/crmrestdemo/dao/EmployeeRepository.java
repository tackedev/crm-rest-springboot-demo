package com.tackedev.springboot.crmrestdemo.dao;

import com.tackedev.springboot.crmrestdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
