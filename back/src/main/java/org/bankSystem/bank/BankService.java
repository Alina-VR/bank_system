package org.bankSystem.bank;

import org.bankSystem.account.AbstractAccount;
import org.bankSystem.account.Credit;
import org.bankSystem.account.Debit;
import org.bankSystem.client.Client;
import org.bankSystem.data.Data;

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

    public static void seeAccountInformation(String accountId) {

        String login;
        if (accountId.contains("debit")) {
            Debit account = (Debit) Data.ACCOUNT_DATA.get(accountId);
            login = account.getLogin();
            System.out.println("Account type: " + account.getAccountType());

            System.out.println("Balance: " + account.getBalance());

        } else {
            Credit account = (Credit) Data.ACCOUNT_DATA.get(accountId);
            login = account.getLogin();
            System.out.println("Account type: " + account.getAccountType());

            System.out.println("Debt: " + account.getCreditDebt());
        }

        Client client = Data.RUNTIME_DATA.get(login);
        System.out.println("Client: " + client.getUserName() + " " + client.getUserSurname());
    }

    public static void suspendAccount(String accountId) {
        AbstractAccount account = Data.ACCOUNT_DATA.get(accountId);
        account.setActive(false);
    }

    public static void unlockAccount(String accountId) {
        AbstractAccount account = Data.ACCOUNT_DATA.get(accountId);
        account.setActive(true);
    }

    public static void assignDebt(String accountId) {
        Credit account = (Credit) Data.ACCOUNT_DATA.get(accountId);
        account.debt();
    }
}

