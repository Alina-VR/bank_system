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
    public int findLogin(String userName, String userSurname) {
        return 0;
    }

    ;public AbstractClient(String userName, String userSurname,
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

    public Bank chooseBank(String bank) {
        // ls banks
        // list of banks
        Bank currBank = new Bank();
        return currBank;
    }
// bank has been added illegally!
    public Account chooseAccount(String account, String bank) {
        Bank currBank = chooseBank(bank);
        if (account.equals("credit")) {
            return currBank.credit();
        } else if (account.equals("debit")) {
            return currBank.debit();
        } else {
            System.out.println("Error");
            return null;
        }
    }
    // account and bank have been added illegally!
    public void chooseOption(String option, int sum, String account, String bank) {
        Account currAccount = chooseAccount(account, bank);
        if (option.equals("push")){
            currAccount.push(sum);
        } else if (option.equals("get")){
            currAccount.get(sum);
        } else {
            System.out.println("Error");
        }
    }

    public abstract String setID(String userName, String userSurname, String passport);
}

