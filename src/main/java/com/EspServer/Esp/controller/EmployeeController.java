package com.EspServer.Esp.controller;

import com.EspServer.Esp.domain.EmployeeDTO;
import com.EspServer.Esp.entities.Account;
import com.EspServer.Esp.repository.AccountEmployeeRepository;
import com.EspServer.Esp.repository.AccountRepository;
import com.EspServer.Esp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.OpenOption;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("/create-employee")
    public void createEmployee(@RequestHeader("acount") UUID accountId, @RequestBody EmployeeDTO employeeDTO) {
        Optional<Account> account = accountRepository.findById(accountId);
        employeeService.createEmployee(employeeDTO, accountId);
    }

}
