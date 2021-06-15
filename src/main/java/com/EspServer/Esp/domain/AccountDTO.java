package com.EspServer.Esp.domain;

import com.EspServer.Esp.entities.RoleName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

public class AccountDTO {
    @JsonProperty
    @NonNull
    private String accountName;
    @JsonProperty
    @NonNull
    private String password;

    @JsonProperty
    @NonNull
    private RoleName roleName;

    private LocalDateTime createDate ;
    private LocalDateTime lastUpdate;

    public AccountDTO(@NonNull String accountName,
                      @NonNull String password,
                      @NonNull RoleName roleName) {
        this.accountName = accountName;
        this.password = password;
        this.roleName = roleName;
        this.createDate = LocalDateTime.now();
        this.lastUpdate = LocalDateTime.now();
    }

    @NonNull
    public String getAccountName() {
        return accountName;
    }

    public void setUserName(@NonNull String accountName) {
        this.accountName = accountName;
    }

    public void setAccountName(@NonNull String accountName) {
        this.accountName = accountName;
    }

    @NonNull
    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(@NonNull RoleName roleName) {
        this.roleName = roleName;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
