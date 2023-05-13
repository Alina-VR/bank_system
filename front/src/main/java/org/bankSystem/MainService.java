package org.bankSystem;

import java.util.Scanner;

public final class MainService {
    private MainService() {

    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the BankSystem!");
        System.out.println("Do you want to continue as a bank or as a customer?");
        String roleChoice = scanner.next();
        if (roleChoice.equals("customer")) {

            ClientInterface.client();

        } else if (roleChoice.equals("bank")) {

            BankInterface.bank();

        }
    }
}
