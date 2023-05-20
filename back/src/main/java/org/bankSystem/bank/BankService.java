package org.bankSystem.bank;

import org.bankSystem.account.AbstractAccount;
import org.bankSystem.account.Credit;
import org.bankSystem.account.Debit;
import org.bankSystem.client.Client;
import org.bankSystem.data.Data;

/** Just a service class for banks */
public final class BankService {

    /** Empty constructor */
    private BankService() { }

    /**
     * This method allows you to see info about bank
     * @param bank - current bank
     */
    public static void seeInformation(Bank bank) {
        System.out.println("bank: " + bank.getBankName());
        System.out.println("registration number: " + bank.getRegistrationID());
        System.out.println("credit limit: " + bank.getCreditLimit());
        System.out.println("fee: " + bank.getFee());
    }

    /**
     * This method allows you to see all bank's accounts
     * @param bank - current bank
     */
    public static boolean seeAccounts(Bank bank) {
        if (bank.getAccounts().isEmpty()) {
            System.out.println("There are not accounts in your bank.");
            return false;
        }
        for (String account: bank.getAccounts()) {
            System.out.println(account);
        }
        return true;
    }

    /**
     * This method allows you to see info about account in your bank
     * @param accountId - current account
     */
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

    /**
     * This method allows you to suspend an account
     * @param accountId - current account
     */
    public static void suspendAccount(String accountId) {
        AbstractAccount account = Data.ACCOUNT_DATA.get(accountId);
        account.setActive(false);
    }

    /**
     * This method allows you to unlock an account
     * @param accountId - current account
     */
    public static void unlockAccount(String accountId) {
        AbstractAccount account = Data.ACCOUNT_DATA.get(accountId);
        account.setActive(true);
    }

    /**
     * This method allows you to get % from credit account
     * @param accountId - current account
     */
    public static void assignDebt(String accountId) {
        Credit account = (Credit) Data.ACCOUNT_DATA.get(accountId);
        account.debt();
    }
}

