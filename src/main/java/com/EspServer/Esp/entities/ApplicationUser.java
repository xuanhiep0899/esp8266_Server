package com.EspServer.Esp.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "application_user")
public class ApplicationUser {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;
    @Column(name = "employee_id", nullable = false)
    private UUID employeeId;
    @Column(name = "username", nullable = false)
    private String userName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "verified", nullable = false)
    private boolean verified;
    @Column(name = "created_date", nullable = false)
    private LocalDateTime createDate;
    @Column(name = "last_update", nullable = false)
    private LocalDateTime last_update;

    public ApplicationUser(UUID id, UUID employeeId, String userName, String password,
                           boolean verified, LocalDateTime createDate, LocalDateTime last_update) {
        this.id = id;
        this.employeeId = employeeId;
        this.userName = userName;
        this.password = password;
        this.verified = verified;
        this.createDate = createDate;
        this.last_update = last_update;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }
}
