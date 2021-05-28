package com.EspServer.Esp.Service;

import com.EspServer.Esp.Domain.AccountDTO;
import com.EspServer.Esp.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountDTO createAccount() {
        return null;
    }

}
