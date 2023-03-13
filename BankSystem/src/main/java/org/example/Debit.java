package org.example;

public class Debit extends Account {

    public Debit(int balance, String login, String bankName, String accountType) {
        super(balance, login, bankName, accountType);
    }

    @Override
    public void push(int sum) {

    }

    @Override
    public void get(int sum) {

    }

}
