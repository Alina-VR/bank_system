package org.bankSystem;

import java.util.Scanner;
import org.bankSystem.bank.Bank;
import org.bankSystem.client.Client;
import org.bankSystem.data.Data;

public final class Authorization {

    private Authorization() {

    }

    public static Bank bankSignIn() {
        Scanner scanner = new Scanner(System.in);
        Bank currBank;
        System.out.println("BankName: ");
        String bankName = scanner.next();

        currBank = Data.BANKS.get(bankName);
        System.out.println("Registration ID: ");
        String registrationID = scanner.next();

        if (!registrationID.equals(currBank.getRegistrationID())) {
            System.out.println("Registration ID: ");
            String secondRegistrationID = scanner.next();

            if (!secondRegistrationID.equals(currBank.getRegistrationID())) {
                System.out.println("Access denied");
                System.exit(1);
            }
        }
        return currBank;
    }

    public static Bank bankSignUp() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bank name: ");
        String bankName = scanner.next();

        System.out.println("Registration ID: ");
        String registrationID = scanner.next();

        System.out.println("Credit Limit: ");
        int creditLimit = scanner.nextInt();

        System.out.println("Fee: ");
        double fee = scanner.nextDouble();

        Bank currBank = new Bank(bankName, registrationID, creditLimit, fee);
        Data.BANKS.put(currBank.getBankName(), currBank);
        return currBank;
    }

    public static Client clientSignIn() {
        Scanner scanner = new Scanner(System.in);
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

    public static Client clientSignUp() {
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

        Client currClient = new Client(name, surname, address, passport, login, password);
        Data.RUNTIME_DATA.put(currClient.getLogin(), currClient);
        return currClient;
    }
}
