package com.example.demo.Repository;

import com.example.demo.model.Employee;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findByName(String name, Pageable pageable);
}
