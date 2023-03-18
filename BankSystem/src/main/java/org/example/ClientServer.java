package org.example;

import java.util.Scanner;

public class ClientServer {
    public static Client signIn() {
        Scanner scanner = new Scanner(System.in);
        Client currClient = null;
        System.out.println("Login: ");
        String login = scanner.next();
        currClient = Base.runtimeBase.get(login);
        System.out.println("Password: ");
        String password = scanner.next();
        if (!password.equals(currClient.password)) {
            System.out.println("Password: ");
            String secondPassword = scanner.next();
            if (!secondPassword.equals(currClient.password)) {
                System.out.println("Access denied");
                System.exit(1);
            }
        }
        return currClient;
    }

    public static Client signUp() {
        Scanner scanner = new Scanner(System.in);
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

        Client currClient = new Client(name, surname, address, passport, login, password, null);
        Base.runtimeBase.put(currClient.login, currClient);
        return currClient;
    }

    public static Account createAccount(Client currClient) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Bank: ");
        for (Bank element:
             Base.banks) {
            System.out.println(element.bankName);
        }
        String bankName = scanner.next();
        System.out.println("Choose account type (debit/credit): ");
        String accountType = scanner.next();
        Account currAccount;
        if (accountType.equals("debit")) {
            currAccount = new Debit(0, currClient.login, bankName, accountType);
            currAccount.setID(currClient.login, bankName, accountType);
            Base.accountBase.put(currAccount.ID, currAccount);
        } else if (accountType.equals("credit")) {
            currAccount = new Credit(0, currClient.login, bankName, accountType);
            currAccount.setID(currClient.login, bankName, accountType);
            Base.accountBase.put(currAccount.ID, currAccount);
        } else {
            System.out.println("Error");
            System.exit(1);
            currAccount = null;
        }
        return currAccount;
    }


    public static void workWithAccount(String element, Client currClient) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the option: push/withdraw ");
        if (scanner.next().equals("push")) {
            System.out.println("Write down the sum ");
            int sum = scanner.nextInt();
            for (Bank bank : Base.banks) {
                if (element.contains(bank.bankName)) { //// Bank -> bank
                    if (element.contains("debit")) {
                        Debit currDebit = bank.debit(Base.accountBase.get(element).balance,
                                Base.accountBase.get(element).login,
                                Base.accountBase.get(element).bankName,
                                Base.accountBase.get(element).accountType);
                        currDebit.push(sum);
                    } else if (element.contains("credit")) {
                        Credit currCredit = bank.credit(Base.accountBase.get(element).balance,
                                Base.accountBase.get(element).login,
                                Base.accountBase.get(element).bankName,
                                Base.accountBase.get(element).accountType);
                        currCredit.push(sum);
                    }
                }
            }
        } else if (scanner.next().equals("withdraw")) {
            System.out.println("Write down the sum ");
            int sum = scanner.nextInt();
            for (Bank bank : Base.banks) {
                if (element.contains(bank.bankName)) { /// Bank -> bank
                    if (element.contains("debit")) {
                        Debit currDebit = bank.debit(Base.accountBase.get(currClient.login).balance,
                                Base.accountBase.get(currClient.login).login,
                                Base.accountBase.get(currClient.login).bankName,
                                Base.accountBase.get(currClient.login).accountType);

                        currDebit.withdraw(sum);
                    } else if (element.contains("credit")) {
                        Credit currCredit = bank.credit(Base.accountBase.get(currClient.login).balance,
                                Base.accountBase.get(currClient.login).login,
                                Base.accountBase.get(currClient.login).bankName,
                                Base.accountBase.get(currClient.login).accountType);
                        currCredit.withdraw(sum);
                    }
                }
            }
        }
    }
}

