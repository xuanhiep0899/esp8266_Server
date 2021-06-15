package com.EspServer.Esp.repository;

import com.EspServer.Esp.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
//    @Query("SELECT e FROM Account e WHERE e.accountName = ?1")
    public Account findAccountByAccountName(String username);
}
