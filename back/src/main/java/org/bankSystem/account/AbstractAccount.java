package org.bankSystem.account;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractAccount {
    @JsonProperty("ID")
    private String id;
    @JsonProperty("login")
    private String login;
    @JsonProperty("bankName")
    private String bankName;
    @JsonProperty("accountType")
    private String accountType;

    public AbstractAccount(final String login,
                           final String bankName, final String accountType) {
        this.login = login;
        this.bankName = bankName;
        this.accountType = accountType;
        this.id = AbstractAccount.createId(login, bankName, accountType);
    }

    public static String createId(final String login, final String bankName,
                                  final String accountType) {
        return login + bankName + accountType;
    }

    public abstract void push(int sum);

    public abstract void withdraw(int sum);

    public abstract void checkBalance();

    @Override
    public String toString() {
        return id + " " + login + " " + bankName + " "
                + accountType;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }
}