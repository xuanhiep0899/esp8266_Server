package com.EspServer.Esp.repository;

import com.EspServer.Esp.entities.AccountEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountEmployeeRepository extends JpaRepository<AccountEmployee, UUID> {
}
