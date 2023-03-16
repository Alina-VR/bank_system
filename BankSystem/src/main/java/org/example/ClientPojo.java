package org.example;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter
@Setter
public class ClientPojo {
    String userName;
    String userSurname;
    String address;
    String passport;
    String login;
    String password;
    LinkedList<String> accounts;

    public ClientPojo(String userName, String userSurname,
                      String address, String passport,
                      String login, String password, LinkedList<String> accounts){

        this.userName = userName;
        this.userSurname = userSurname;
        this.address = address;
        this.passport = passport;
        this.login = login;
        this.password = password;
        this.accounts = accounts;

    }

    public ClientPojo(){
        this.userName = null;
        this.userSurname = null;
        this.address = null;
        this.passport = null;
        this.login = null;
        this.password = null;
        this.accounts = null;

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\"Client [UserName " + userName + ", UserSurname = " + userSurname + ", Address = " + address +
                ", Passport = " + passport + ", Login = " + login + ", Password = " + password +
                ", Account = " + accounts + "]";
    }

}