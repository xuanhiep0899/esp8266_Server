package com.EspServer.Esp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

public class AccountDTO {
    @JsonProperty
    @NonNull
    private String accountName;
    @JsonProperty
    @NonNull
    private String password;

    private LocalDateTime createDate ;
    private LocalDateTime lastUpdate;

    public AccountDTO(@NonNull String accountName, @NonNull String password) {
        this.accountName = accountName;
        this.password = password;
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
