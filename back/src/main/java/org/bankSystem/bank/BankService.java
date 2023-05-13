package org.bankSystem.bank;

public final class BankService {

    private BankService() { }

    public static void seeInformation(Bank bank) {
        System.out.println("bank: " + bank.getBankName());
        System.out.println("registration number: " + bank.getRegistrationID());
        System.out.println("credit limit: " + bank.getCreditLimit());
        System.out.println("fee: " + bank.getFee());
    }

    public static void seeAccounts(Bank bank) {
        for (String account: bank.getAccounts()) {
            System.out.println(account);
        }
    }
}
