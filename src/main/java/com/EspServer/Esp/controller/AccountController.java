package com.EspServer.Esp.controller;

import com.EspServer.Esp.domain.AccountDTO;
import com.EspServer.Esp.entities.Account;
import com.EspServer.Esp.repository.AccountRepository;
import com.EspServer.Esp.service.AccountService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @PostMapping("create-account")
    public void addAccount(@RequestBody AccountDTO accountDTO) {
        accountService.accountDtoToAccount(accountDTO);
    }
}
