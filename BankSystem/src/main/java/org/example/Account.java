package org.example;

public abstract class Account {
    public int balance;// TODO: домножать на 100 суммы
    public String login;
    public String bankName;
    public String accountType;
    public String ID;

    public Account(int balance,
            String login,
            String bankName,
            String accountType) {
         this.balance = balance;
         this.login = login;
         this.bankName = bankName;
         this.accountType = accountType;
         ///this.ID = ID;
    }


    public void setID(String login, String bankName, String accountType){
        ID = login+bankName+accountType;
    }

    public abstract void push(int sum);

    public abstract void get(int sum);

}

