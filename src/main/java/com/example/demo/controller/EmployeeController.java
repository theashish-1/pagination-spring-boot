package com.example.demo.controller;

import com.example.demo.Service.EmployeeService;
import com.example.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired

    private EmployeeService employeeService;


    //Sorting
    //parameters : 1 : sortBy example name , id etc
    //parameter 2 : sortDirection : example asc,des

    @GetMapping("/list")
    public List<Employee> getEmployee(@RequestParam(required = false,defaultValue = "1") int pageNumber,
                                      @RequestParam(required = false,defaultValue = "5") int pageSize,
                                      @RequestParam(required = false,defaultValue = "id") String sortBy,
                                      @RequestParam(required = false,defaultValue = "ASC") String sortDir,
                                      @RequestParam(required = false,defaultValue = "") String search){
//        Sort.by(sortBy).descending();
        Sort sort = null;

        if(sortDir.equalsIgnoreCase("ASC")){
            sort = Sort.by(sortBy).ascending();
        }else{
            sort = Sort.by(sortBy).descending();
        }
        return employeeService.fetchAllEmployee(
                PageRequest.of(pageNumber - 1, pageSize, sort),
                search
        );

    }

}
