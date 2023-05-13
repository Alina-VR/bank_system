package org.bankSystem.bank;

public class Bank extends AbstractBank {

    public Bank(final String bankName, final String registrationID, final int creditLimit,
                final double fee) {
        super(bankName, registrationID, creditLimit, fee);
    }

    public Bank() {

    }
}
