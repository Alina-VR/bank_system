package org.example;

import java.util.Scanner;

public class ClientServer {
    public static Client signIn(String sign) {
        Scanner scanner = new Scanner(System.in);
        Client currClient = null;
        System.out.println("Login: ");
        String login = scanner.next();
        currClient = Base.runtimeBase.get(login);
        System.out.println("Password: ");
        String password = scanner.next();
        if (!password.equals(currClient.password)) {
            System.out.println("Access denied");
            System.exit(1);
        }
        return currClient;
    }

    public static Client signUp(String sign) {
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
        if (scanner.next().equals("create")) {
            System.out.println("Choose Bank: ");
            String bankName = scanner.next();
            System.out.println("Choose account type (debit/credit): ");
            String accountType = scanner.next();
            Account currAccount;
            if (accountType.equals("debit")) {
                currAccount = new Debit(0, currClient.login, bankName, accountType);
            } else if (accountType.equals("credit")) {
                currAccount = new Credit(0, currClient.login, bankName, accountType);
            } else {
                System.out.println("Error");
                System.exit(1);
                currAccount = null;
            }
            return currAccount;
        } else {
            return null;
        }
    }
    public static Account workWithAccount() {

    }
    public static void workWithCredit() {

    }
}

