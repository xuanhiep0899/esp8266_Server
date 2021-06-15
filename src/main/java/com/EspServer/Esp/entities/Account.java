package com.EspServer.Esp.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "password")
    private String password;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "last_updated")
    private LocalDateTime lastUpdate;
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    public Account(String accountName, String password,
                   RoleName roleName, LocalDateTime createdDate,
                   LocalDateTime lastUpdate) {
        this.password = password;
        this.accountName = accountName;
        this.roleName = roleName;
        this.createdDate = createdDate;
        this.lastUpdate = lastUpdate;
    }

    public Account(String accountName, String password, RoleName roleName) {
        this.roleName = roleName;
        this.accountName = accountName;
        this.password = password;
    }

    public Account() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return accountName + " " + password + " " + createdDate + " " + lastUpdate;
    }
}
