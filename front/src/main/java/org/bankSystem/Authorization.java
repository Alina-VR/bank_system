package org.bankSystem;

import java.util.Scanner;
import org.bankSystem.bank.Bank;
import org.bankSystem.client.Client;
import org.bankSystem.data.Data;

/** Authorization class */
public final class Authorization {

    /** Empty constructor */
    private Authorization() {

    }

    /** This method provides sign in operation for bank */
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
            } else if (answer.equals("n")) {
                System.out.println("Good bye!");
                System.exit(0);
            } else {

                System.out.println("Please, type y or n:");
                String secondAnswer = scanner.next();

                if (secondAnswer.equals("y")) {
                    currBank = bankSignUp();
                } else if (secondAnswer.equals("n")) {
                    System.out.println("Good bye!");
                    System.exit(0);
                } else {
                    System.out.print("Sorry, our program can't understand your requests. ");
                    System.out.println("Please, read README.md to use it.");
                    System.exit(0);
                }
            }
        } else {

            currBank = Data.BANKS.get(bankName);
            System.out.println("Registration ID: ");
            String registrationID = scanner.next();

            if (!registrationID.equals(currBank.getRegistrationID())) {
                System.out.println("Incorrect ID. Please, try again: ");
                String secondRegistrationID = scanner.next();

                if (!secondRegistrationID.equals(currBank.getRegistrationID())) {
                    System.out.println("Access denied");
                    System.exit(0);
                }
            }
        }
        return currBank;
    }

    /** This method provides sign up operation for bank */
    public static Bank bankSignUp() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bank name: ");
        String bankName = scanner.next();
        Bank currBank;

        if (Data.BANKS.containsKey(bankName)) {
            System.out.println("Bank with this name already exists.");
            System.out.println("Do you want to sign in? (y/n)");

            if (scanner.next().equals("y")) {
                System.out.println("Sign in:");
                currBank = bankSignIn();
            } else {
                System.out.println("Sign up:");
                currBank = bankSignUp();
            }
        } else {

            System.out.println("Registration ID: ");
            String registrationID = scanner.next();

            System.out.println("Credit Limit: ");
            String enteredLimit = scanner.next();

            while (!isNatural(enteredLimit)) {
                System.out.println("Enter format is natural number.");
                enteredLimit = scanner.next();
            }

            int creditLimit = Integer.parseInt(enteredLimit);

            System.out.println("Fee: ");
            String enteredFee = scanner.next();

            while (!isNumeric(enteredFee)) {
                System.out.println("Enter format is *.* . Please, use a point, not a comma!");
                enteredFee = scanner.next();
            }

            double fee = Double.parseDouble(enteredFee);

            currBank = new Bank(bankName, registrationID, creditLimit, fee);
            Data.BANKS.put(currBank.getBankName(), currBank);
        }
        return currBank;
    }

    /** This method provides sign in operation for client */
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

    /** This method provides sign up operation for  client */
    public static Client clientSignUp() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login: ");
        String login = scanner.next();
        Client currClient;

        if (Data.RUNTIME_DATA.containsKey(login)) {
            System.out.println("Client with this login already exists.");
            System.out.println("Do you want to sign in? (y/n)");

            if (scanner.next().equals("y")) {
                System.out.println("Sign in:");
                currClient = clientSignIn();

            } else {
                System.out.println("Sign up:");
                currClient = clientSignUp();
            }

        } else {

            System.out.println("Name: ");
            String name = scanner.next();

            System.out.println("Surname: ");
            String surname = scanner.next();

            System.out.println("Address: ");
            String address = scanner.next();

            System.out.println("Passport: ");
            String passport = scanner.next();

            System.out.println("Password: ");
            String password = scanner.next();

            currClient = new Client(name, surname, address, passport, login, password);
            Data.RUNTIME_DATA.put(currClient.getLogin(), currClient);
        }
        return currClient;
    }

    /** Just a checker */
    public static boolean isNatural(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /** Just a checker */
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
