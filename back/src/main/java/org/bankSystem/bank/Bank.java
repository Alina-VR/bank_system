package org.bankSystem.bank;

/** Not abstract bank */
public class Bank extends AbstractBank {

    /** Constructor */
    public Bank(final String bankName, final String registrationID, final int creditLimit,
                final double fee) {
        super(bankName, registrationID, creditLimit, fee);
    }

    /** Empty constructor */
    public Bank() {

    }
}
