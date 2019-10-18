package com.luv2code.springboot.thymeleafdemo.controller;


import com.luv2code.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    // load employee data
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData() {
        // create employees
        Employee emp1 = new Employee(1, "nacer", "Bouchek-0", "nbouchek-0@luv2code.com");
        Employee emp2 = new Employee(2, "Nasse", "Bouchek-1", "nbouchek-1@luv2code.com");
        Employee emp3 = new Employee(3, "Nasro", "Bouchek-2", "nbouchek-2@luv2code.com");
        Employee emp4 = new Employee(4, "Abdul", "Bouchek-3", "nbouchek-3@luv2code.com");

        // create the list
        theEmployees = new ArrayList<>();

        // add to the list
        theEmployees.add(emp1);
        theEmployees.add(emp2);
        theEmployees.add(emp3);
        theEmployees.add(emp4);
    }
    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "list-employees";
    }
}
