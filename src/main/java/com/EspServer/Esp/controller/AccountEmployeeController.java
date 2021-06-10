package com.EspServer.Esp.controller;

import com.EspServer.Esp.service.AccountEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/account-employee")
public class AccountEmployeeController {

    @Autowired
    private AccountEmployeeService accountEmployeeService;

    @GetMapping("get")
    public void getAccount(@RequestHeader("accountemployeeID") UUID id){
        accountEmployeeService.getAccountEmployee(id);
    }
}
