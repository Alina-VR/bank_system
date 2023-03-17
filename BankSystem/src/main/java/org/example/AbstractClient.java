package org.example;

import java.util.LinkedList;

abstract class AbstractClient {
    String userName;
    String userSurname;
    String address;
    String passport;
    String login;
    String password;
    LinkedList<String> accounts;

    //ID
    ///public int findLogin(String userName, String userSurname) {
    ///return 0;
    ///}

    ;

    public AbstractClient(String userName, String userSurname,
                          String address, String passport,
                          String login, String password, LinkedList<String> accounts) {
        this.userName = userName;
        this.userSurname = userSurname;
        this.address = address;
        this.passport = passport;
        this.login = login;
        this.password = password;
        this.accounts = accounts;

    }

    public AbstractClient() {
        this.userName = null;
        this.userSurname = null;
        this.address = null;
        this.passport = null;
        this.login = null;
        this.password = null;
        this.accounts = null;

    }
}
