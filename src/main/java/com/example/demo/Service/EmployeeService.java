package com.example.demo.Service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public List<Employee> fetchAllEmployee(Pageable pageable) {
        return employeeRepository.findAll(pageable).getContent();

    }
}
