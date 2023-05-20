package org.bankSystem.account;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** Account list class */
public class AccountsList {
    /** List of debits */
    @JsonProperty("Debits")
    private List<Debit> debits;
    /** List of credits */
    @JsonProperty("Credits")
    private List<Credit> credits;

    /** Constructor */
    public AccountsList(final List<Debit> debits, final List<Credit> credits) {
        this.debits = debits;
        this.credits = credits;
    }

    AccountsList() {
    }

    /** List of debits getter */
    public List<Debit> getDebits() {
        return debits;
    }

    /** List of debits setter*/
    public void setDebits(final List<Debit> debits) {
        this.debits = debits;
    }

    /** List of credits getter */
    public List<Credit> getCredits() {
        return credits;
    }

    /** List of credits setter */
    public void setCredits(final List<Credit> credits) {
        this.credits = credits;
    }
}
