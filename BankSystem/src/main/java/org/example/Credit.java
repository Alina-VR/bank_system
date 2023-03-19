package org.example;

public class Credit extends Account {
    int creditLimit;
    double fee;
    int creditDebt;

    public Credit(int balance, String login, String bankName, String accountType) {
        super(balance, login, bankName, accountType);
    }


    @Override
    public void push(int sum) {
        debt -= sum;
        System.out.println("Your new balance is " + balance);
    }

    @Override
    public void withdraw(int sum) {
        if (sum <= creditLimit) {
            balance -= sum;
            creditDebt += sum * (1 + fee);
            System.out.println("Withdraw " + sum);
            System.out.println("Your new balance is " + balance);
            System.out.println("Debt is " + creditDebt);
        } else {
            System.out.println("Exceed limit");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Your balance is " + balance);
    }

    public void getDebt(Account account) {
        account.debt += creditDebt;
    }
}
