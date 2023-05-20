package org.bankSystem.client;

import org.bankSystem.account.AbstractAccount;
import org.bankSystem.account.Credit;
import org.bankSystem.account.Debit;
import org.bankSystem.bank.Bank;
import org.bankSystem.data.Data;

/** Just a service class for clients */
public final class ClientService {

    /** Empty constructor */
    private ClientService() {

    }

    /**
     * This method creates an account
     * @param bankName name of account's bank
     * @param accountType type of account
     * @param currClient account's user
     * @param currBank account's bank
     * @return new account
     */
    public static AbstractAccount createAccount(String bankName, String accountType, Client currClient, Bank currBank) {
        Client client = Data.RUNTIME_DATA.get(currClient.getLogin());
        AbstractAccount currAbstractAccount;
        if (accountType.equals("debit")) {
            currAbstractAccount = new Debit(currClient.getLogin(), bankName, accountType, true, 0);
            Data.ACCOUNT_DATA.put(currAbstractAccount.getId(), currAbstractAccount);

        } else if (accountType.equals("credit")) {
            currAbstractAccount = new Credit(currClient.getLogin(), bankName, accountType,
                    true, 0, currBank.getCreditLimit(),
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

    /**
     * This method provides push operation
     * @param element account's ID
     * @param sum just a sum of money
     */
    public static void push(final String element, int sum) {
        for (Bank bank : Data.BANKS.values()) {
            if (element.contains(bank.getBankName())) {
                if (element.contains("debit")) {
                    Debit currDebit = new Debit(Data.ACCOUNT_DATA.get(element).getLogin(),
                            Data.ACCOUNT_DATA.get(element).getBankName(),
                            Data.ACCOUNT_DATA.get(element).getAccountType(),
                            Data.ACCOUNT_DATA.get(element).getActive(),
                            ((Debit) Data.ACCOUNT_DATA.get(element)).getBalance());

                    currDebit.push(sum, true);
                    Data.ACCOUNT_DATA.put(element, currDebit);

                } else if (element.contains("credit")) {
                    Credit currCredit = new Credit(Data.ACCOUNT_DATA.get(element).getLogin(),
                            Data.ACCOUNT_DATA.get(element).getBankName(),
                            Data.ACCOUNT_DATA.get(element).getAccountType(),
                            Data.ACCOUNT_DATA.get(element).getActive(),
                            ((Credit) Data.ACCOUNT_DATA.get(element)).getCreditDebt(),
                            ((Credit) Data.ACCOUNT_DATA.get(element)).getCreditLimit(),
                            ((Credit) Data.ACCOUNT_DATA.get(element)).getFee());

                    currCredit.push(sum, true);
                    Data.ACCOUNT_DATA.put(element, currCredit);
                }
            }
        }
    }

    /**
     * This method provides withdraw operation
     * @param element account's ID
     * @param sum just a sum of money
     */
    public static void withdraw(final String element, int sum) {
        for (Bank bank : Data.BANKS.values()) {
            if (element.contains(bank.getBankName())) {

                if (element.contains("debit")) {
                    Debit currDebit = new Debit(Data.ACCOUNT_DATA.get(element).getLogin(),
                            Data.ACCOUNT_DATA.get(element).getBankName(),
                            Data.ACCOUNT_DATA.get(element).getAccountType(),
                            Data.ACCOUNT_DATA.get(element).getActive(),
                            ((Debit) Data.ACCOUNT_DATA.get(element)).getBalance());

                    currDebit.withdraw(sum, true);
                    Data.ACCOUNT_DATA.put(element, currDebit);

                } else if (element.contains("credit")) {
                    Credit currCredit = new Credit(Data.ACCOUNT_DATA.get(element).getLogin(),
                            Data.ACCOUNT_DATA.get(element).getBankName(),
                            Data.ACCOUNT_DATA.get(element).getAccountType(),
                            Data.ACCOUNT_DATA.get(element).getActive(),
                            ((Credit) Data.ACCOUNT_DATA.get(element)).getCreditDebt(),
                            ((Credit) Data.ACCOUNT_DATA.get(element)).getCreditLimit(),
                            ((Credit) Data.ACCOUNT_DATA.get(element)).getFee());

                    currCredit.withdraw(sum, true);
                    Data.ACCOUNT_DATA.put(element, currCredit);
                }
            }
        }
    }

    /**
     * This method provides transfer operation
     * @param yourAccountID account's "from" ID
     * @param goalAccountID account's "to" ID
     * @param sum just a sum of money
     */
    public static void transfer(String yourAccountID, String goalAccountID, int sum) {
        Debit yourAccount = (Debit) Data.ACCOUNT_DATA.get(yourAccountID);
        Debit goalAccount = (Debit) Data.ACCOUNT_DATA.get(goalAccountID);
        if (sum > yourAccount.getBalance()) {
            System.out.println("Insufficient funds");
        } else {
            yourAccount.withdraw(sum, false);
            Data.ACCOUNT_DATA.put(goalAccountID, goalAccount);
            goalAccount.push(sum, false);
            Data.ACCOUNT_DATA.put(yourAccountID, yourAccount);
            System.out.println("Transferred " + sum);
        }
    }
}
