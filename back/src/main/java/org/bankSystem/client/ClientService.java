package org.bankSystem.client;

import org.bankSystem.account.AbstractAccount;
import org.bankSystem.account.Credit;
import org.bankSystem.account.Debit;
import org.bankSystem.bank.Bank;
import org.bankSystem.data.Data;

public final class ClientService {

    private ClientService() {

    }

    public static AbstractAccount createAccount(String bankName, String accountType, Client currClient, Bank currBank) {
        Client client = Data.RUNTIME_DATA.get(currClient.getLogin());
        AbstractAccount currAbstractAccount;
        if (accountType.equals("debit")) {
            currAbstractAccount = new Debit(currClient.getLogin(), bankName, accountType, 0);
            Data.ACCOUNT_DATA.put(currAbstractAccount.getId(), currAbstractAccount);

        } else if (accountType.equals("credit")) {
            currAbstractAccount = new Credit(currClient.getLogin(), bankName, accountType, 0, currBank.getCreditLimit(),
                    currBank.getFee());
            Data.ACCOUNT_DATA.put(currAbstractAccount.getId(), currAbstractAccount);

        } else {
            System.out.println("Error");
            System.exit(1);
            currAbstractAccount = null;
        }
        client.getAccounts().add(currAbstractAccount.getId());
        currBank.getAccounts().add(currAbstractAccount.getId());
        return currAbstractAccount;
    }

    public static void push(final String element, int sum) {
        for (Bank bank : Data.BANKS.values()) {
            if (element.contains(bank.getBankName())) {
                if (element.contains("debit")) {
                    Debit currDebit = new Debit(Data.ACCOUNT_DATA.get(element).getLogin(),
                            Data.ACCOUNT_DATA.get(element).getBankName(),
                            Data.ACCOUNT_DATA.get(element).getAccountType(),
                            ((Debit) Data.ACCOUNT_DATA.get(element)).getBalance());

                    currDebit.push(sum);
                    Data.ACCOUNT_DATA.put(element, currDebit);

                } else if (element.contains("credit")) {
                    Credit currCredit = new Credit(Data.ACCOUNT_DATA.get(element).getLogin(),
                            Data.ACCOUNT_DATA.get(element).getBankName(),
                            Data.ACCOUNT_DATA.get(element).getAccountType(),
                            ((Credit) Data.ACCOUNT_DATA.get(element)).getCreditDebt(),
                            ((Credit) Data.ACCOUNT_DATA.get(element)).getCreditLimit(),
                            ((Credit) Data.ACCOUNT_DATA.get(element)).getFee());

                    currCredit.push(sum);
                    Data.ACCOUNT_DATA.put(element, currCredit);
                }
            }
        }
    }

    public static void withdraw(final String element, int sum) {
        for (Bank bank : Data.BANKS.values()) {
            if (element.contains(bank.getBankName())) {

                if (element.contains("debit")) {
                    Debit currDebit = new Debit(Data.ACCOUNT_DATA.get(element).getLogin(),
                            Data.ACCOUNT_DATA.get(element).getBankName(),
                            Data.ACCOUNT_DATA.get(element).getAccountType(),
                            ((Debit) Data.ACCOUNT_DATA.get(element)).getBalance());

                    currDebit.withdraw(sum);
                    Data.ACCOUNT_DATA.put(element, currDebit);

                } else if (element.contains("credit")) {
                    Credit currCredit = new Credit(Data.ACCOUNT_DATA.get(element).getLogin(),
                            Data.ACCOUNT_DATA.get(element).getBankName(),
                            Data.ACCOUNT_DATA.get(element).getAccountType(),
                            ((Credit) Data.ACCOUNT_DATA.get(element)).getCreditDebt(),
                            ((Credit) Data.ACCOUNT_DATA.get(element)).getCreditLimit(),
                            ((Credit) Data.ACCOUNT_DATA.get(element)).getFee());

                    currCredit.withdraw(sum);
                    Data.ACCOUNT_DATA.put(element, currCredit);
                }
            }
        }
    }

    public static void transfer(String yourAccountID, String goalAccountID, int sum) {
        Debit yourAccount = (Debit) Data.ACCOUNT_DATA.get(yourAccountID);
        Debit goalAccount = (Debit) Data.ACCOUNT_DATA.get(goalAccountID);
        if (sum > yourAccount.getBalance()) {
            System.out.println("Insufficient funds");
        } else {
            yourAccount.withdraw(sum);
            Data.ACCOUNT_DATA.put(goalAccountID, goalAccount);
            goalAccount.push(sum);
            Data.ACCOUNT_DATA.put(yourAccountID, yourAccount);
        }
    }
}
