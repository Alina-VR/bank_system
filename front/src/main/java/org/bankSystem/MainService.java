package org.bankSystem;

import java.util.Scanner;

/** Main service class */
public final class MainService {
    /** Empty constructor */
    private MainService() {

    }

    /** Starter of interface */
    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue as a bank (1) or as a client (2)? Type 1 or 2:");
        String roleChoice = scanner.next();
        if (roleChoice.equals("2")) {

            ClientInterface.client();

        } else if (roleChoice.equals("1")) {

            BankInterface.bank();

        } else {

            System.out.println("Please, enter only symbols from brackets. Do you want to continue? (y/n)");
            String answer = scanner.next();

            if (answer.equals("y")) {
                start();
            } else if (answer.equals("n")) {
                System.out.println("Good bye!");
                System.exit(0);
            } else {

                System.out.println("Please, type y or n:");
                String secondAnswer = scanner.next();

                if (secondAnswer.equals("y")) {
                    start();
                } else if (secondAnswer.equals("n")) {
                    System.out.println("Good bye!");
                    System.exit(0);
                } else {
                    System.out.print("Sorry, our program can't understand your requests. ");
                    System.out.println("Please, read README.md to use it.");
                    System.exit(0);
                }
            }
        }
    }
}
