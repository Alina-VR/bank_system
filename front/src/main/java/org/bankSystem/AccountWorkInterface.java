package org.bankSystem;

import java.util.Scanner;
import org.bankSystem.account.AbstractAccount;
import org.bankSystem.client.ClientService;
import org.bankSystem.data.Data;

public final class AccountWorkInterface {

    private AccountWorkInterface() {

    }

    public static void workWithAccount(final String element) {
        Scanner scanner = new Scanner(System.in);
        if (!Data.ACCOUNT_DATA.get(element).getActive()) {
            System.out.println("Sorry, your account has been blocked by your bank.");
            System.out.println("Please, call the office to get asses back.");
            System.exit(0);
        }

        System.out.println("Choose the option:");
        System.out.println("-> push (1)");
        System.out.println("-> withdraw (2)");

        if (element.contains("debit")) {
            System.out.println("-> transfer (3)");
        }

        String answer = scanner.next();

        switch (answer) {
            case "1":
                push(element);
                break;
            case "2":
                withdraw(element);
                break;
            case "3":
                transfer(element);
                break;
            default:
                System.out.println("error");
                break;
        }

    }

    public static void push(final String element) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write down the sum ");
        int sum = scanner.nextInt();
        ClientService.push(element, sum);
    }

    public static void withdraw(final String element) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write down the sum ");
        int sum = scanner.nextInt();
        ClientService.withdraw(element, sum);
    }

    public static void transfer(final String yourAccountID) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose debit account which you want " + "to transfer your money to");
        for (AbstractAccount goalAccount : Data.ACCOUNT_DATA.values()) {
            if (goalAccount.getId().contains("debit") && !goalAccount.getId().equals(yourAccountID)) {
                System.out.println(goalAccount.getId());
            }
        }
        String goalAccountID = scanner.next();
        System.out.println("Write down the sum");
        int sum = scanner.nextInt();

        ClientService.transfer(yourAccountID, goalAccountID, sum);
    }
}
