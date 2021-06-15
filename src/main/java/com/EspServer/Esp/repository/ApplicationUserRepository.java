package com.EspServer.Esp.repository;

import com.EspServer.Esp.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface ApplicationUserRepository extends JpaRepository<Account, UUID> {

}
