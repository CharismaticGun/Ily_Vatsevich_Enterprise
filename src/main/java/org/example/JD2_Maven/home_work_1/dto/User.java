package org.example.JD2_Maven.home_work_1.dto;

import java.time.LocalDate;

public class User {

    private String login;

    private char[] password;

    private String firstSecondThirdName;

    private String dateOfBirth;

    private LocalDate dateOfRegistration;

    private String role;

    public User(){}

    public User(String login, char[] password, String firstSecondThirdName, String dateOfBirth, LocalDate dateOfRegistration, String role) {
        this.login = login;
        this.password = password;
        this.firstSecondThirdName = firstSecondThirdName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegistration = dateOfRegistration;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public String getFirstSecondThirdName() {
        return firstSecondThirdName;
    }

    public void setFirstSecondThirdName(String firstSecondThirdName) {
        this.firstSecondThirdName = firstSecondThirdName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
