package org.example;

public class Credit extends Account {
    int creditLimit;
    double fee;
    int debt;

    public Credit(int balance, String login, String bankName, String accountType) {
        super(balance, login, bankName, accountType);
    }


    @Override
    public void push(int sum) {
        debt -= sum;
        System.out.println("Your new balance is " + balance);
    }

    @Override
    public void get(int sum) {
        if (sum <= creditLimit) {
            balance -= sum;
            debt += sum * (1 + fee);
            System.out.println("Withdraw " + sum);
            System.out.println("Your new balance is " + balance);
            System.out.println("Debt is " + debt);
        } else {
            System.out.println("Exceed limit");
        }
    }
}
