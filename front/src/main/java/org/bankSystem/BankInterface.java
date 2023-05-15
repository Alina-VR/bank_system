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

        Bank currBank = bankAuthorization();

        while (!scanner.next().equals("no")) {

            bankWork(currBank);

            Data.saveData("b");
            System.out.println("Continue? (yes/no) ");
        }
        System.out.println("Good Bye!");
    }

    public static Bank bankAuthorization() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sign_in/ sign_up ");
        String sign = scanner.next();
        Bank currBank = new Bank();

        if (sign.equals("sign_in")) {
            currBank = Authorization.bankSignIn();

        } else if (sign.equals("sign_up")) {
            currBank = Authorization.bankSignUp();
        }
        Data.saveData("b");
        System.out.println("Continue? (yes/no) ");
        return currBank;
    }

    public static void bankWork(Bank currBank) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to see the accounts list (1) "
                + "or information about bank (2)? Type 1 or 2");
        if (scanner.nextInt() == 1) {
            BankService.seeAccounts(currBank);
        } else {
            BankService.seeInformation(currBank);
        }
    }
}
