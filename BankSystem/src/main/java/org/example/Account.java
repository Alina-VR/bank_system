package org.example;

public abstract class Account {
    public int balance;
    public String login;
    public String bankName;
    public String accountType;

    public Account(int balance,
            String login,
            String bankName,
            String accountType) {
         this.balance = balance;
         this.login = login;
         this.bankName = bankName;
         this.accountType = accountType;
    }

    public String setID(String login, String bankName, String accountType){
        return login+bankName+accountType;
    }

    public abstract void push(int sum);

    public abstract void get(int sum);

}

