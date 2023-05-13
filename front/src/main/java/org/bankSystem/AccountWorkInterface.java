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
        if (element.contains("debit")) {
            System.out.println("Choose the option: push/withdraw/transfer ");

        } else {
            System.out.println("Choose the option: push/withdraw ");
        }
        String answer = scanner.next();

        switch (answer) {
            case "push":
                push(element);
                break;
            case "withdraw":
                withdraw(element);
                break;
            case "transfer":
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
            if (goalAccount.getId().contains("debit")) {
                System.out.println(goalAccount.getId());
            }
        }
        String goalAccountID = scanner.next();
        System.out.println("Write down the sum");
        int sum = scanner.nextInt();

        ClientService.transfer(yourAccountID, goalAccountID, sum);
    }
}
