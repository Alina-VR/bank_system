package org.bankSystem.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/** Just an abstract class for clients */
public abstract class AbstractClient {
    /** Client's login */
    @JsonProperty("Login")
    private String login;
    /** Client's password */
    @JsonProperty("Password")
    private String password;
    /** Client's accounts */
    @JsonProperty("Accounts")
    private List<String> accounts;
    /** Client's name */
    @JsonProperty("UserName")
    private String userName;
    /** Client's surname */
    @JsonProperty("UserSurname")
    private String userSurname;
    /** Client's address */
    @JsonProperty("Address")
    private String address;
    /** Client's passport */
    @JsonProperty("Passport")
    private String passport;

    /** Constructor*/
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

    /** Empty constructor */
    public AbstractClient() {
    }

    /** This method give a string interpretation of the client */
    @Override
    public String toString() {
        return "User name: " + userName + ", User Surname: " + userSurname + ", Address: " + address
                + ", Passport: " + passport + ", Login: " + login + ", Password: " + password;
    }

    /** Login getter */
    public String getLogin() {
        return login;
    }

    /** Login setter */
    public void setLogin(final String login) {
        this.login = login;
    }

    /** Password getter */
    public String getPassword() {
        return password;
    }

    /** Password setter */
    public void setPassword(final String password) {
        this.password = password;
    }

    /** Accounts getter */
    public List<String> getAccounts() {
        return accounts;
    }

    /** Accounts setter */
    public void setAccounts(final List<String> accounts) {
        this.accounts = accounts;
    }

    /** Name getter */
    public String getUserName() {
        return userName;
    }

    /** Name setter */
    public void setUserName(final String userName) {
        this.userName = userName;
    }

    /** Surname getter */
    public String getUserSurname() {
        return userSurname;
    }

    /** Surname setter */
    public void setUserSurname(final String userSurname) {
        this.userSurname = userSurname;
    }

    /** Address getter */
    public String getAddress() {
        return address;
    }

    /** Address setter */
    public void setAddress(final String address) {
        this.address = address;
    }

    /** Passport getter */
    public String getPassport() {
        return passport;
    }

    /** Passport setter */
    public void setPassport(final String passport) {
        this.passport = passport;
    }
}
