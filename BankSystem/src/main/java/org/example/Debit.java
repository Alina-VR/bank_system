package org.example;

public class Debit extends Account {

    public Debit(int balance, String login, String bankName, String accountType) {
        super(balance, login, bankName, accountType);
    }

    @Override
    public void push(int sum) {
        balance += sum;
        System.out.println("Your new balance is " + balance);
    }

    @Override
    public void get(int sum) {
        if (sum <= balance) {
            balance -= sum;
            System.out.println("Withdraw " + sum);
            System.out.println("Your new balance is " + balance);
        } else {
            System.out.println("Insufficient funds"); // change comment
        }
    }
}
