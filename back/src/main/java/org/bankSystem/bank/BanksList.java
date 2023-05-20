package org.bankSystem.bank;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

public class BanksList {
    @JsonProperty("Banks")
    private List<Bank> banks;

    public BanksList(final List<Bank> banks) {
        this.banks = banks;
    }

    public BanksList() {
        banks = new ArrayList<>();
    }

    public List<Bank> toBanksArray() {
        return new ArrayList<>(banks);
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(final List<Bank> banks) {
        this.banks = banks;
    }

}
