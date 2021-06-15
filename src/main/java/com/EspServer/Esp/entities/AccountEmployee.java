package com.EspServer.Esp.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "account_employee")
public class AccountEmployee {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "last_updated")
    private LocalDateTime lastUpdate;

    public AccountEmployee(Account account, Employee employee
            ,LocalDateTime createdDate, LocalDateTime lastUpdate){
        this.id = id;
        this.account = account;
        this.employee = employee;
        this.createdDate = createdDate;
        this.lastUpdate = lastUpdate;
    }

    public AccountEmployee() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
}
