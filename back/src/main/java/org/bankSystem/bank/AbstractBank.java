package org.bankSystem.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBank {
    /** Name of tne bank */
    @JsonProperty("BankName")
    private String bankName;
    /** To check if it is a real bank */
    @JsonProperty("RegistrationID")
    private String registrationID;
    /** List of bank accounts */
    @JsonProperty("Accounts")
    private List<String> accounts;
    /** Bank credit limit */
    @JsonProperty("CreditLimit")
    private int creditLimit;
    /** Bank % */
    @JsonProperty("Fee")
    private double fee;

    /** Constructor */
    public AbstractBank(final String bankName, final String registrationID,
                        final int creditLimit, final double fee) {
        this.bankName = bankName;
        this.registrationID = registrationID;
        this.creditLimit = creditLimit;
        this.fee = fee;
        this.accounts = new ArrayList<>();
    }

    /** Empty constructor */
    public AbstractBank() {
    }

    /** This method give a string interpretation of the bank */
    @Override
    public String toString() {
        return bankName + " " + registrationID + " " + creditLimit + " " + fee;
    }

    /** Name getter */
    public String getBankName() {
        return bankName;
    }

    /** Name setter */
    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    /** ID getter */
    public String getRegistrationID() {
        return registrationID;
    }

    /** ID setter */
    public void setRegistrationID(final String registrationID) {
        this.registrationID = registrationID;
    }

    /** Limit getter */
    public int getCreditLimit() {
        return creditLimit;
    }

    /** Limit setter */
    public void setCreditLimit(final int creditLimit) {
        this.creditLimit = creditLimit;
    }

    /** Fee getter */
    public double getFee() {
        return fee;
    }

    /** Name setter */
    public void setFee(final double fee) {
        this.fee = fee;
    }

    /** List of accounts getter */
    public List<String> getAccounts() {
        return accounts;
    }

    /** List of accounts setter */
    public void setAccounts(final List<String> accounts) {
        this.accounts = accounts;
    }
}
