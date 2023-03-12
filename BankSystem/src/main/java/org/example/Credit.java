package org.example;

public class Credit extends Account{

    public Credit(int balance, String login, String bankName, String accountType) {
        super(balance, login, bankName, accountType);
    }

    @Override
    public void push(int sum) {

    }

    @Override
    public void get(int sum) {

    }
}
