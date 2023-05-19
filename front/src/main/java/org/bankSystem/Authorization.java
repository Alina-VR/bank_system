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

        if (currBank == null) {

            System.out.println("You don't have an account yet. Do you want to sign up? (y/n)");
            String answer = scanner.next();
            if (answer.equals("y")) {
                currBank = bankSignUp();
            } else {
                System.out.println("Good bye!");
                System.exit(0);
            }
        } else {

            currBank = Data.BANKS.get(bankName);
            System.out.println("Registration ID: ");
            String registrationID = scanner.next();

            if (!registrationID.equals(currBank.getRegistrationID())) {
                System.out.println("Registration ID: ");
                String secondRegistrationID = scanner.next();

                if (!secondRegistrationID.equals(currBank.getRegistrationID())) {
                    System.out.println("Access denied");
                    System.exit(0);
                }
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
        String enteredFee = scanner.next();

        while (!isNumeric(enteredFee)) {
            System.out.println("Enter format is ***,***. Please, use a comma, not a point!");
            enteredFee = scanner.next();
        }

        double fee = Double.parseDouble(enteredFee);

        Bank currBank = new Bank(bankName, registrationID, creditLimit, fee);
        Data.BANKS.put(currBank.getBankName(), currBank);
        return currBank;
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Client clientSignIn() {
        Scanner scanner = new Scanner(System.in);
        Client currClient;

        System.out.println("Login: ");
        String login = scanner.next();

        currClient = Data.RUNTIME_DATA.get(login);

        if (currClient == null) {

            System.out.println("You don't have an account yet. Do you want to sign up? (y/n)");
            String answer = scanner.next();
            if (answer.equals("y")) {
                currClient = clientSignUp();
            } else {
                System.out.println("Good bye!");
                System.exit(0);
            }
        } else {

            System.out.println("Password: ");
            String password = scanner.next();

            if (!password.equals(currClient.getPassword())) {
                System.out.println("Password: ");
                String secondPassword = scanner.next();

                if (!secondPassword.equals(currClient.getPassword())) {
                    System.out.println("Access denied");
                    System.exit(0);
                }
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
