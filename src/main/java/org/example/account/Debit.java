package org.example.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Debit extends AbstractAccount {
    @JsonProperty("balance")
    private int balance;

    public Debit(final String login, final String bankName,
                 final String accountType, int balance) {
        super(login, bankName, accountType);
        this.balance = balance;
        this.setId(AbstractAccount.createId(login, bankName, accountType));
    }

    public Debit() {
        super("", "", "");
        this.balance = 0;
    }

    @Override
    public String toString() {
        return "type: " + getAccountType() + ", balance: " + balance;
    }

    @Override
    public void push(final int sum) {
        //add sum to balance
        balance += sum;
        System.out.println("Your new balance is " + balance);
    }

    @Override
    public void withdraw(final int sum) {
        //get sum from balance
        if (sum <= balance) {
            balance -= sum;
            System.out.println("Withdraw " + sum);
            System.out.println("Your new balance is " + balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Your balance is " + balance);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(final int balance) {
        this.balance = balance;
    }

}

