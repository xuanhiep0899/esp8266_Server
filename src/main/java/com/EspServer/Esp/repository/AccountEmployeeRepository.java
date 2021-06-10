package com.EspServer.Esp.repository;

import com.EspServer.Esp.entities.AccountEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountEmployeeRepository extends JpaRepository<AccountEmployee, UUID> {
    public AccountEmployee findAccountEmployeeById(UUID id);
}
