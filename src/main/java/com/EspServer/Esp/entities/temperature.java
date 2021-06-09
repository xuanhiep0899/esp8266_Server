package com.EspServer.Esp.entities;

import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Table(name = "temperature")
public class temperature {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @Column(name = "temperature_value")
    private Double temperatureValue;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @Column(name = "last_update")
    private LocalDateTime lastUpdate;

//    public temperature(UUID id, Employee employee, Double temperatureValue, LocalDateTime createdDate, LocalDateTime lastUpdate) {
//        this.id = id;
//        this.employee = employee;
//        this.temperatureValue = temperatureValue;
//        this.createdDate = createdDate;
//        this.lastUpdate = lastUpdate;
//    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(Double temperatureValue) {
        this.temperatureValue = temperatureValue;
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
