package com.EspServer.Esp.controller;

import com.EspServer.Esp.entities.Employee;
import com.EspServer.Esp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class WebController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String getEmployee(Model model) {
        List<Employee> list = employeeRepository.findAll();
        model.addAttribute("employee", list);
        return "home";
    }

    @RequestMapping(value = "/api/employee/get-employee", method = RequestMethod.GET)
    public String getEmployeeFromAccount(Model model) {
        List<Employee> list = employeeRepository.findAll();
        model.addAttribute("employee", list);
        return "index";
    }
}
