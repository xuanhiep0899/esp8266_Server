package com.EspServer.Esp.domain;

import com.EspServer.Esp.entities.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

public class EmployeeDTO {

    @JsonProperty
    @NonNull
    private String firstName;
    @JsonProperty
    @NonNull
    private String lastName;
    @JsonProperty
    @NonNull
    private String age;
    @JsonProperty
    @NonNull
    private String email;
    @JsonProperty
    @NonNull
    private String phoneNumber;

    public EmployeeDTO() {
    }

    public EmployeeDTO(@NonNull String firstName, @NonNull String lastName, @NonNull String age,
                       @NonNull String email, @NonNull String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    public String getAge() {
        return age;
    }

    public void setAge(@NonNull String age) {
        this.age = age;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NonNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee toEntity() {
        Employee employee = new Employee();
        employee.setFirstName(this.getFirstName());
        employee.setLastName(this.getLastName());
        return employee;
    }
}
