package org.bankSystem.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/** Bank list class */
public class BanksList {
    /** List of banks */
    @JsonProperty("Banks")
    private List<Bank> banks;

    /** Constructor */
    public BanksList(final List<Bank> banks) {
        this.banks = banks;
    }

    /** Empty constructor */
    public BanksList() {
        banks = new ArrayList<>();
    }

    /** Change list structure */
    public List<Bank> toBanksArray() {
        return new ArrayList<>(banks);
    }

    /** Banks list getter */
    public List<Bank> getBanks() {
        return banks;
    }

    /** Banks list setter */
    public void setBanks(final List<Bank> banks) {
        this.banks = banks;
    }

}
