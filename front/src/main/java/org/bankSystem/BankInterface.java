package org.bankSystem;

import java.util.Scanner;
import org.bankSystem.bank.Bank;
import org.bankSystem.bank.BankService;
import org.bankSystem.data.Data;

public final class BankInterface {

    private BankInterface() {

    }

    public static void bank() {
        Scanner scanner = new Scanner(System.in);

        Bank currBank = bankAuthorization(true);

        while (!scanner.next().equals("n")) {

            bankWork(currBank);

            Data.saveData("b");
            System.out.println("Do you want to continue? (y/n) ");
        }
        System.out.println("Good Bye!");
    }

    public static Bank bankAuthorization(boolean firstTime) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose: sign_in (1) / sign_up (2)");
        String sign = scanner.next();
        Bank currBank = new Bank();

        if (sign.equals("1")) {
            currBank = Authorization.bankSignIn();

        } else if (sign.equals("2")) {
            currBank = Authorization.bankSignUp();
        } else {
            System.out.println("Please, enter only symbols from brackets. Do you want to continue? (y/n)");
            String answer = scanner.next();
            if (answer.equals("y")) {
                currBank = bankAuthorization(false);
            } else if (answer.equals("n")) {
                System.out.println("Good bye!");
                System.exit(0);
            } else {
                System.out.println("Please, type y or n.");
                String secondAnswer = scanner.next();
                if (secondAnswer.equals("y")) {
                    currBank = bankAuthorization(false);
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
        Data.saveData("b");
        if (firstTime) {
            System.out.println("Continue? (y/n) ");
        }
        return currBank;
    }

    public static void bankWork(Bank currBank) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the option:");
        System.out.println("-> see the accounts list (1)");
        System.out.println("-> see information about bank (2)");
        System.out.println("-> see account information (3)");
        System.out.println("-> suspect account (4)");
        System.out.println("-> unlock account (5)");
        System.out.println("-> assign debt (6)");
        System.out.println("If you want to escape enter 'bye'.");

        boolean flag;
        switch (scanner.next()) {
            case "bye":
                System.out.println("Good bye!");
                System.exit(0);
                break;
            case "2":
                BankService.seeInformation(currBank);
                break;
            case "3":
                System.out.println("Choose account:");
                flag = BankService.seeAccounts(currBank);
                if (flag) {
                    BankService.seeAccountInformation(scanner.next());
                }
                break;
            case "4":
                System.out.println("Choose account:");
                flag = BankService.seeAccounts(currBank);
                if (flag) {
                    BankService.suspendAccount(scanner.next());
                }
                break;
            case "5":
                System.out.println("Choose account:");
                flag = BankService.seeAccounts(currBank);
                if (flag) {
                    BankService.unlockAccount(scanner.next());
                }
                break;
            case "6":
                System.out.println("Choose account:");
                flag = BankService.seeAccounts(currBank);
                if (flag) {
                    BankService.assignDebt(scanner.next());
                }
                break;
            default:
                BankService.seeAccounts(currBank);
                break;
        }
        Data.saveData("all");
    }
}
