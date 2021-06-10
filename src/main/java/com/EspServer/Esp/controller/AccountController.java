package com.EspServer.Esp.controller;

import com.EspServer.Esp.domain.AccountDTO;
import com.EspServer.Esp.entities.Account;
import com.EspServer.Esp.repository.AccountRepository;
import com.EspServer.Esp.service.AccountEmployeeService;
import com.EspServer.Esp.service.AccountService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping
    public void addAccount(@RequestBody AccountDTO accountDTO) {
        accountService.accountDtoToAccount(accountDTO);
    }
}
