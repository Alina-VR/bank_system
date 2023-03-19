package org.example;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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
    }


    public void setID(String login, String bankName, String accountType){
        ID = login+bankName+accountType;
    }

    public abstract void push(int sum);

    public abstract void withdraw(int sum);

    public static Account toAccount(AccountPOJO accountPOJO) {
        Account account;
        if (accountPOJO.accountType.equals("debit")) {
            account = new Debit(accountPOJO.balance, accountPOJO.login, accountPOJO.bankName, accountPOJO.accountType);
        } else {
            account = new Credit(accountPOJO.balance, accountPOJO.login, accountPOJO.bankName, accountPOJO.accountType);
        }
        account.ID = accountPOJO.ID;


        return account;
    }

    public abstract void checkBalance();

    @Override
    public String toString() {
        return ID + " " + login + " " + bankName + " " + accountType + " " + balance;
    }

}

