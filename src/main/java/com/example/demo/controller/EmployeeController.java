package com.example.demo.controller;

import com.example.demo.Service.EmployeeService;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired

    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> getEmployee(@RequestParam(required = false,defaultValue = "1") int pageNumber,
                                      @RequestParam(required = false,defaultValue = "5") int pageSize){
        return employeeService.fetchAllEmployee(PageRequest.of(pageNumber-1, pageSize));
    }

}
