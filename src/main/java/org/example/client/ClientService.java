package org.example.client;

import org.example.account.AbstractAccount;
import org.example.account.Credit;
import org.example.account.Debit;
import org.example.bank.Bank;
import org.example.data.Data;

import java.util.Scanner;

public final class ClientService {
    static Scanner scanner;

    private ClientService() {
    }

    public static void reset() {
        scanner = new Scanner(System.in);
    }

    public static Client signIn() {
        Client currClient;

        System.out.println("Login: ");
        String login = scanner.next();

        currClient = Data.RUNTIME_DATA.get(login);
        System.out.println("Password: ");
        String password = scanner.next();

        if (!password.equals(currClient.getPassword())) {
            System.out.println("Password: ");
            String secondPassword = scanner.next();

            if (!secondPassword.equals(currClient.getPassword())) {
                System.out.println("Access denied");
                System.exit(1);
            }
        }
        return currClient;
    }

    public static Client signUp() {
        System.out.println("Name: ");
        String name = scanner.next();

        System.out.println("Surname: ");
        String surname = scanner.next();

        System.out.println("Address: ");
        String address = scanner.next();

        System.out.println("Passport: ");
        String passport = scanner.next();

        System.out.println("Login: ");
        String login = scanner.next();

        System.out.println("Password: ");
        String password = scanner.next();

        Client currClient = new Client(name, surname, address, passport, login, password);
        Data.RUNTIME_DATA.put(currClient.getLogin(), currClient);
        return currClient;
    }

    public static AbstractAccount createAccount(final Client currClient) {
        Client client = Data.RUNTIME_DATA.get(currClient.getLogin());
        System.out.println("Choose Bank: ");

        for (Bank element : Data.BANKS.values()) {
            System.out.println(element.getBankName());
        }

        String bankName = scanner.next();
        Bank currBank = Data.BANKS.get(bankName);
        System.out.println("Choose account type (debit/credit): ");
        String accountType = scanner.next();
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

    public static void workWithAccount(final String element, final Client currClient) {
        if (element.contains("debit")) {
            System.out.println("Choose the option: push/withdraw/transfer ");

        } else {
            System.out.println("Choose the option: push/withdraw ");
        }
        String answer = scanner.next();

        if (answer.equals("push")) {
            push(element, currClient);
        } else if (answer.equals("withdraw")) {
            withdraw(element, currClient);
        } else if (answer.equals("transfer")) {
            transfer(element, currClient);
        }
    }

    public static void push(final String element, final Client currClient) {
        System.out.println("Write down the sum ");
        int sum = scanner.nextInt();

        for (Bank bank : Data.BANKS.values()) {
            if (element.contains(bank.getBankName())) {
                if (element.contains("debit")) {
                    Debit currDebit = new Debit(Data.ACCOUNT_DATA.get(element).getLogin(),
                        Data.ACCOUNT_DATA.get(element).getBankName(), Data.ACCOUNT_DATA.get(element).getAccountType(),
                        ((Debit) Data.ACCOUNT_DATA.get(element)).getBalance());

                    currDebit.push(sum);
                    Data.ACCOUNT_DATA.put(element, currDebit);

                } else if (element.contains("credit")) {
                    Credit currCredit = new Credit(Data.ACCOUNT_DATA.get(element).getLogin(),
                        Data.ACCOUNT_DATA.get(element).getBankName(), Data.ACCOUNT_DATA.get(element).getAccountType(),
                        ((Credit) Data.ACCOUNT_DATA.get(element)).getCreditDebt(),
                        ((Credit) Data.ACCOUNT_DATA.get(element)).getCreditLimit(),
                        ((Credit) Data.ACCOUNT_DATA.get(element)).getFee());

                    currCredit.push(sum);
                    Data.ACCOUNT_DATA.put(element, currCredit);
                }
            }
        }
    }

    public static void withdraw(final String element, final Client currClient) {
        System.out.println("Write down the sum ");
        int sum = scanner.nextInt();

        for (Bank bank : Data.BANKS.values()) {
            if (element.contains(bank.getBankName())) {

                if (element.contains("debit")) {
                    Debit currDebit = new Debit(Data.ACCOUNT_DATA.get(element).getLogin(),
                        Data.ACCOUNT_DATA.get(element).getBankName(), Data.ACCOUNT_DATA.get(element).getAccountType(),
                        ((Debit) Data.ACCOUNT_DATA.get(element)).getBalance());

                    currDebit.withdraw(sum);
                    Data.ACCOUNT_DATA.put(element, currDebit);

                } else if (element.contains("credit")) {
                    Credit currCredit = new Credit(Data.ACCOUNT_DATA.get(element).getLogin(),
                        Data.ACCOUNT_DATA.get(element).getBankName(), Data.ACCOUNT_DATA.get(element).getAccountType(),
                        ((Credit) Data.ACCOUNT_DATA.get(element)).getCreditDebt(),
                        ((Credit) Data.ACCOUNT_DATA.get(element)).getCreditLimit(),
                        ((Credit) Data.ACCOUNT_DATA.get(element)).getFee());

                    currCredit.withdraw(sum);
                    Data.ACCOUNT_DATA.put(element, currCredit);
                }
            }
        }
    }

    public static void transfer(final String yourAccountID, final Client currClient) {
        Debit yourAccount = (Debit) Data.ACCOUNT_DATA.get(yourAccountID);
        System.out.println("Choose debit account which you want " + "to transfer your money to");
        for (AbstractAccount goalAccount : Data.ACCOUNT_DATA.values()) {
            if (goalAccount.getId().contains("debit")) {
                System.out.println(goalAccount.getId());
            }
        }
        String goalAccountID = scanner.next();
        Debit goalAccount = (Debit) Data.ACCOUNT_DATA.get(goalAccountID);
        System.out.println("Write down the sum");
        int sum = scanner.nextInt();
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


