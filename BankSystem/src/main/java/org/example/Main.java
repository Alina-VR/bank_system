package org.example;


import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sign in/ sign up ");
        String sign = scanner.next();
        Client currClient = null;
        if (sign.equals("sign in")) {
            System.out.println("Login: ");
            String login = scanner.next();
            Client currentClient = Base.base.get(login);
            System.out.println("Password: ");
            String password = scanner.next();
            if (!password.equals(currentClient.password)) {
                System.out.println("Access denied");
                System.exit(1);
            }

        } else if (sign.equals("sign up")) {
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

            currClient = new Client(name, surname, address, passport, login, password, null);
            Base.base.put(currClient.login, currClient);

        }

        System.out.println("There are your accounts here: ");
        if (currClient.accounts != null) {
            for (String element : currClient.accounts) {
                System.out.println(element);
            }
            System.out.println("Choose account or create a new one");
            System.out.println("If you want to choose any account enter it's name from the list");
        } else {
            System.out.println("You have not got any accounts yet");
        }
        System.out.println("If you want to create a new one enter 'create'");
        if (scanner.next().equals("create")) {
            System.out.println("Choose Bank: ");
            String bankName = scanner.next();
            System.out.println("Choose account type (debit/credit): ");
            String accountType = scanner.next();
            if (accountType.equals("debit")) {
                Debit currAccount = new Debit();
            } else if (accountType.equals("credit")) {
                Credit currAccount = new Credit();
            } else {
                System.out.println("Error");
                System.exit(1);
            }

            //String currID = currAccount.setID();

        }
    }
}