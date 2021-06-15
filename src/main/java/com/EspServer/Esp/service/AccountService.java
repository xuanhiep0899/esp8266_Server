package com.EspServer.Esp.service;

import com.EspServer.Esp.domain.AccountDTO;
import com.EspServer.Esp.entities.Account;
import com.EspServer.Esp.entities.RoleName;
import com.EspServer.Esp.repository.AccountRepository;
import exception.AccountDoesNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountEmployeeService accountEmployeeService;


    public void createAccount(AccountDTO accountDTO) {
        Account account = new Account(accountDTO.getAccountName(),accountDTO.getPassword(),
                RoleName.ROLE_ADMIN, accountDTO.getCreateDate(), accountDTO.getLastUpdate());
        accountRepository.save(account);
    }

    public int count() {
        return accountRepository.findAll().size();
    }

    public void updateAccount(String accountName, AccountDTO accountDTO) {
        Optional<Account> accountOptional = Optional.ofNullable(accountRepository.findAccountByAccountName(accountName));

        if (!accountOptional.isPresent()) {
            throw new AccountDoesNotExistsException("Exception");
        }
        Account account = accountOptional.get();
        account.setPassword(accountDTO.getPassword());
        accountRepository.save(account);
    }

    public void deleteAccount(String accountName) {
        Optional<Account> accountOptional = Optional.ofNullable(accountRepository.findAccountByAccountName(accountName));

        if (!accountOptional.isPresent()) {
            throw new AccountDoesNotExistsException("Exception");
        }
        Account account = accountOptional.get();
        accountRepository.delete(account);
    }
}
