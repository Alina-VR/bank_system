package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
public class ClientPOJO {
    @JsonProperty("UserName")
    String UserName;
    @JsonProperty("UserSurname")
    String UserSurname;
    @JsonProperty("Address")
    String address;
    @JsonProperty("Passport")
    String passport;
    @JsonProperty("Login")
    String login;
    @JsonProperty("Password")
    String password;
    @JsonProperty("Accounts")
    List<String> accounts;

    public ClientPOJO() {}

    public ClientPOJO(AbstractClient client) {
        this.UserName = client.userName;
        this.UserSurname = client.userSurname;
        this.address = client.address;
        this.passport = client.passport;
        this.login = client.login;
        this.password = client.password;
        this.accounts = client.accounts;
    }

    @Override
    public String toString() {
        return UserName + " " + UserSurname + " " + address + " " + passport + " " + login + " " + password + " " + accounts;
    }
}
