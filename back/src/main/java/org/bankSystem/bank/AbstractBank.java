package org.bankSystem.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBank {
    @JsonProperty("BankName")
    private String bankName;
    @JsonProperty("RegistrationID")
    private String registrationID;
    @JsonProperty("Accounts")
    private List<String> accounts;
    @JsonProperty("CreditLimit")
    private int creditLimit;

    @JsonProperty("Fee")
    private double fee;

    public AbstractBank(final String bankName, final String registrationID,
                        final int creditLimit, final double fee) {
        this.bankName = bankName;
        this.registrationID = registrationID;
        this.creditLimit = creditLimit;
        this.fee = fee;
        this.accounts = new ArrayList<>();
    }

    public AbstractBank() {
    }

    @Override
    public String toString() {
        return bankName + " " + registrationID + " " + creditLimit + " " + fee;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(final String registrationID) {
        this.registrationID = registrationID;
    }

    public int getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(final int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(final double fee) {
        this.fee = fee;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(final List<String> accounts) {
        this.accounts = accounts;
    }
}
