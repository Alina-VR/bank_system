package org.bankSystem.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Debit extends AbstractAccount {
    @JsonProperty("balance")
    private int balance;

    public Debit(final String login, final String bankName,
                 final String accountType, final boolean active, int balance) {
        super(login, bankName, accountType, active);
        this.balance = balance;
        this.setId(AbstractAccount.createId(login, bankName, accountType));
    }

    public Debit() {
        super("", "", "", true);
        this.balance = 0;
    }

    @Override
    public String toString() {
        return "type: " + getAccountType() + ", balance: " + balance;
    }

    @Override
    public void push(final int sum, boolean massage) {
        //add sum to balance
        balance += sum;
        if (massage) {
            System.out.println("Your new balance is " + balance);
        }
    }

    @Override
    public void withdraw(final int sum, boolean massage) {
        //get sum from balance
        if (sum <= balance) {
            balance -= sum;
            if (massage) {
                System.out.println("Withdraw " + sum);
                System.out.println("Your new balance is " + balance);
            }
        } else {
            if (massage) {
                System.out.println("You can withdraw only " + balance);
                balance = 0;
                System.out.println("Your new balance is " + balance);
            } else {
                System.out.println("Influenced founds");
            }
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
