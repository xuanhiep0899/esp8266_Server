package com.EspServer.Esp.service;

import com.EspServer.Esp.domain.EmployeeDTO;
import com.EspServer.Esp.entities.Account;
import com.EspServer.Esp.entities.Employee;
import com.EspServer.Esp.repository.AccountRepository;
import com.EspServer.Esp.repository.EmployeeRepository;
import exception.EmployeeAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO createEmployee(UUID accountId, EmployeeDTO employeeDTO) {
        Optional<Account> accountOptional = accountRepository.findById(accountId);

        if (!accountOptional.isPresent()) {
        }

        Employee employee = employeeRepository.findByEmailIgnoreCase(employeeDTO.getEmail());

        if (employee != null) {
            throw new EmployeeAlreadyExistException(employee.getId(), accountId);
        }

//        Employee newEmployee = new Employee(employee.getFirstName(), employeeDTO.getLastName());

//        return newEmployee.toDTO(newEmployee);
        return null;
    }

}
