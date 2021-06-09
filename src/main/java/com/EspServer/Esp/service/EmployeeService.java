package com.EspServer.Esp.service;

import com.EspServer.Esp.domain.EmployeeDTO;
import com.EspServer.Esp.entities.Account;
import com.EspServer.Esp.entities.AccountEmployee;
import com.EspServer.Esp.entities.Employee;
import com.EspServer.Esp.repository.AccountRepository;
import com.EspServer.Esp.repository.EmployeeRepository;
import exception.AccountDoesNotExistsException;
import exception.EmployeeAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AccountEmployeeService accountEmployeeService;

    public EmployeeDTO createEmployee( EmployeeDTO employeeDTO, UUID accountId) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);

        if (!accountOptional.isPresent()) {
            throw new AccountDoesNotExistsException("Exception");
        }
        Employee employee = employeeRepository.findByEmailIgnoreCase(employeeDTO.getEmail());

        if (employee != null) {
            throw new EmployeeAlreadyExistException(employee.getId(), accountOptional.get().getId());
        }
        Account account = accountOptional.get();

        Employee newEmployee = new Employee(employeeDTO.getFirstName(), employeeDTO.getLastName()
                                            ,employeeDTO.getEmail(), employeeDTO.getAge());
        employeeRepository.save(newEmployee);
        accountEmployeeService.createAccountEmployee(account,newEmployee);
        return newEmployee.toDTO(newEmployee);

    }

}
