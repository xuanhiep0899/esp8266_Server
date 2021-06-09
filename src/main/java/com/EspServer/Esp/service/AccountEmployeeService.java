package com.EspServer.Esp.service;

import com.EspServer.Esp.entities.Account;
import com.EspServer.Esp.entities.AccountEmployee;
import com.EspServer.Esp.entities.Employee;
import com.EspServer.Esp.repository.AccountEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountEmployeeService {
    @Autowired
    private AccountEmployeeRepository accountEmployeeRepository;

    public void createAccountEmployee(Account account, Employee employee){
        AccountEmployee accountEmployee = new AccountEmployee(account,employee,
                employee.getCreatedDate(), employee.getLastUpdate());
        accountEmployeeRepository.save(accountEmployee);
    }
}
