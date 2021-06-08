package com.EspServer.Esp.controller;

import com.EspServer.Esp.domain.EmployeeDTO;
import com.EspServer.Esp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "create-employee")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestHeader("Account-Id") UUID accountId,
                                                      @RequestBody EmployeeDTO employeeDTO) {
        return new ResponseEntity<>(employeeService.createEmployee(accountId, employeeDTO), HttpStatus.OK);
    }

}
