package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
abstract class AbstractClient {
    String userName;
    String userSurname;
    String address;
    String passport;
    String login;
    String password;
    List<String> accounts;

    //ID
    ///public int findLogin(String userName, String userSurname) {
    ///return 0;
    ///}

    public AbstractClient(String userName, String userSurname,
                          String address, String passport,
                          String login, String password, ArrayList<String> accounts) {
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

    public static Client toClient(ClientPOJO clientPOJO) {
        Client client = new Client();
        client.login = clientPOJO.getLogin();
        client.passport = clientPOJO.getPassport();
        client.password = clientPOJO.getPassword();
        client.userName = clientPOJO.getUserName();
        client.userSurname = clientPOJO.getUserSurname();
        client.address = clientPOJO.getAddress();


        return client;
    }

    @Override
    public String toString() {
        return userName + " " + userSurname + " " + address + " " + passport + " " + login + " " + password + " " + accounts;
    }

    //    public Bank chooseBank(String bank) {
//        // ls banks
//        // list of banks
//        Bank currBank = new Bank();
//        return currBank;
//    }
//// bank has been added illegally!
//    public Account chooseAccount(String account, String bank) {
//        Bank currBank = chooseBank(bank);
//        if (account.equals("credit")) {
//            return currBank.credit();
//        } else if (account.equals("debit")) {
//            return currBank.debit();
//        } else {
//            System.out.println("Error");
//            return null;
//        }
//    }
//    // account and bank have been added illegally!
//    public void chooseOption(String option, int sum, String account, String bank) {
//        Account currAccount = chooseAccount(account, bank);
//        if (option.equals("push")){
//            currAccount.push(sum);
//        } else if (option.equals("get")){
//            currAccount.get(sum);
//        } else {
//            System.out.println("Error");
//        }
//    }

    /// public abstract String setID(String userName, String userSurname, String passport);
}
