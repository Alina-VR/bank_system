package org.bankSystem.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Credit extends AbstractAccount {
    /** Max sum that you can withdraw */
    @JsonProperty("creditLimit")
    private int creditLimit;
    /** credit % */
    @JsonProperty("fee")
    private double fee;
    /** Sum tof your debt */
    @JsonProperty("creditDebt")
    private int creditDebt;

    /** Empty constructor */
    public Credit() {
        super(" ", " ", " ", true);
        this.creditDebt = 0;
        this.creditLimit = 0;
        this.fee = 0;
    }

    /** Constructor */
    public Credit(final String login, final String bankName,
                  final String accountType, final boolean active,
                  int creditDebt, final int creditLimit, final double fee) {
        super(login, bankName, accountType, active);
        this.creditDebt = creditDebt;
        this.creditLimit = creditLimit;
        this.fee = fee;
        this.setId(AbstractAccount.createId(login, bankName, accountType));
    }

    /**
     * To repay your debt
     * @param sum - money you want to add
     * @param massage - just a boolean constant
     */
    @Override
    public void push(final int sum, boolean massage) {
        // add sum to balance
        if (creditDebt - sum > 0) {
            creditDebt = creditDebt - sum;
        } else if (creditDebt > 0) {
            int change = sum - creditDebt;
            creditDebt = 0;
            System.out.println("Your loan is fully repaid");
            System.out.println("Your change is " + change);
        } else {
            creditDebt = 0;
            System.out.println("Your loan has already been repaid ");
        }
        System.out.println("Now your debt is " + getCreditDebt());
    }

    /**
     * To withdraw money
     * @param sum - money you want to get
     * @param massage - just a boolean constant
     */
    @Override
    public void withdraw(final int sum, boolean massage) {

        if (creditDebt + sum <= creditLimit) {
            creditDebt += sum;
            System.out.println("Withdraw " + sum);
            System.out.println("Now yor debt is " + creditDebt);
        } else if (creditDebt < creditLimit) {
            int withdraw = creditLimit - creditDebt;
            creditDebt = creditLimit;
            System.out.println("You can withdraw only " + withdraw);
            System.out.println("Now your debt is " + creditLimit);
        } else {
            creditDebt = creditLimit;
            System.out.println("Exceed limit, your debt is " + creditDebt);
        }
    }

    /** To get the sum of % */
    public void debt() {
        creditDebt = (int) (creditDebt * (1 + fee));
    }

    /** This method give a string interpretation of the credit */
    @Override
    public String toString() {
        return "type: " + getAccountType() + ", debt: " + creditDebt;
    }

    /** To check balance */
    @Override
    public void checkBalance() {
        System.out.println("Your debt is " + creditDebt);
    }

    /** Limit getter */
    public int getCreditLimit() {
        return creditLimit;
    }

    /** Limit setter */
    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    /** Fee getter */
    public double getFee() {
        return fee;
    }

    /** Fee setter */
    public void setFee(double fee) {
        this.fee = fee;
    }

    /** Debt getter */
    public int getCreditDebt() {
        return creditDebt;
    }

    /** Debt setter */
    public void setCreditDebt(int creditDebt) {
        this.creditDebt = creditDebt;
    }
}
