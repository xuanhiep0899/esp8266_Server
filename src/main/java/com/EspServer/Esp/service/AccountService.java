package com.EspServer.Esp.service;

import com.EspServer.Esp.domain.AccountDTO;
import com.EspServer.Esp.entities.Account;
import com.EspServer.Esp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public void accountDtoToAccount(AccountDTO accountDTO) {
        Account account = new Account(accountDTO.getAccountName(),accountDTO.getPassword(),
                accountDTO.getCreateDate(),accountDTO.getLastUpdate());
        accountRepository.save(account);
    }
}
