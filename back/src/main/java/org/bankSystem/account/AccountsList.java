package org.bankSystem.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class AccountsList {
    @JsonProperty("Debits")
    private List<Debit> debits;
    @JsonProperty("Credits")
    private List<Credit> credits;

    public AccountsList(final List<Debit> debits, final List<Credit> credits) {
        this.debits = debits;
        this.credits = credits;
    }

    AccountsList() {
    }

    public List<Debit> getDebits() {
        return debits;
    }

    public void setDebits(final List<Debit> debits) {
        this.debits = debits;
    }

    public List<Credit> getCredits() {
        return credits;
    }

    public void setCredits(final List<Credit> credits) {
        this.credits = credits;
    }
}
