package org.bankSystem.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/** Just an abstract class for accounts */
public abstract class AbstractAccount {
    /** Account ID */
    @JsonProperty("ID")
    private String id;
    /** Login of client whose this account is */
    @JsonProperty("login")
    private String login;
    /** Bank in which this account is */
    @JsonProperty("bankName")
    private String bankName;
    /** Type of the account */
    @JsonProperty("accountType")
    private String accountType;
    /** It shows if the account is active or blocked */
    @JsonProperty("active")
    private boolean active;

    /** Constructor */
    public AbstractAccount(final String login,
                           final String bankName, final String accountType, final boolean active) {
        this.login = login;
        this.bankName = bankName;
        this.accountType = accountType;
        this.active = active;
        this.id = AbstractAccount.createId(login, bankName, accountType);
    }

    /** Creator of account ID */
    public static String createId(final String login, final String bankName,
                                  final String accountType) {
        return login + bankName + accountType;
    }

    /** This method allows to add money to the account */
    public abstract void push(int sum, boolean massage);

    /** This method allows to grab money from the account */
    public abstract void withdraw(int sum, boolean massage);

    /** This method allows to check balance */
    public abstract void checkBalance();

    /** This method give a string interpretation of the account */
    @Override
    public String toString() {
        return id + " " + login + " " + bankName + " "
                + accountType;
    }

    /** ID getter */
    public String getId() {
        return id;
    }

    /** ID setter */
    public void setId(final String id) {
        this.id = id;
    }

    /** Login getter */
    public String getLogin() {
        return login;
    }

    /** Login setter */
    public void setLogin(final String login) {
        this.login = login;
    }

    /** Bank name getter */
    public String getBankName() {
        return bankName;
    }

    /** Login setter */
    public void setBankName(final String bankName) {
        this.bankName = bankName;
    }

    /** Account type getter */
    public String getAccountType() {
        return accountType;
    }

    /** Account type setter */
    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    /** Is active getter */
    public boolean getActive() {
        return active;
    }

    /** Is active setter */
    public void setActive(boolean active) {
        this.active = active;
    }
}
