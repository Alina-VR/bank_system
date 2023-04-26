package org.example.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractClient {
    @JsonProperty("Login")
    private String login;
    @JsonProperty("Password")
    private String password;
    @JsonProperty("Accounts")
    private List<String> accounts;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("UserSurname")
    private String userSurname;
    @JsonProperty("Address")
    private String address;
    @JsonProperty("Passport")
    private String passport;

    public AbstractClient(final String userName, final String userSurname,
                          final String address, final String passport,
                          final String login, final String password) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.address = address;
        this.passport = passport;
        this.login = login;
        this.password = password;
        this.accounts = new ArrayList<>();
    }

    public AbstractClient() {
    }

    @Override
    public String toString() {
        return "User name: " + userName + ", User Surname: " + userSurname + ", Address: " + address
                + ", Passport: " + passport + ", Login: " + login + ", Password: " + password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(final List<String> accounts) {
        this.accounts = accounts;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(final String userSurname) {
        this.userSurname = userSurname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }
}


