package org.bankSystem.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Debit extends AbstractAccount {
    /** Your debit balance */
    @JsonProperty("balance")
    private int balance;

    /** Constructor */
    public Debit(final String login, final String bankName,
                 final String accountType, final boolean active, int balance) {
        super(login, bankName, accountType, active);
        this.balance = balance;
        this.setId(AbstractAccount.createId(login, bankName, accountType));
    }

    /** Empty constructor */
    public Debit() {
        super("", "", "", true);
        this.balance = 0;
    }

    /** This method give a string interpretation of the debit */
    @Override
    public String toString() {
        return "type: " + getAccountType() + ", balance: " + balance;
    }

    /**
     * To add money
     * @param sum - money you want to add
     * @param massage - just a boolean constant
     */
    @Override
    public void push(final int sum, boolean massage) {
        //add sum to balance
        balance += sum;
        if (massage) {
            System.out.println("Your new balance is " + balance);
        }
    }

    /**
     * To get money
     * @param sum - money you want to add
     * @param massage - just a boolean constant
     */
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

    /** To check balance */
    @Override
    public void checkBalance() {
        System.out.println("Your balance is " + balance);
    }

    /** Balance getter */
    public int getBalance() {
        return balance;
    }

    /** Balance setter */
    public void setBalance(final int balance) {
        this.balance = balance;
    }

}
