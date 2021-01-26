package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Employees;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer>{

}
