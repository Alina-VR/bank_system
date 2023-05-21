package org.bankSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.bankSystem.account.AbstractAccount;
import org.bankSystem.bank.Bank;
import org.bankSystem.client.Client;
import org.bankSystem.client.ClientService;
import org.bankSystem.data.Data;

/** Account creation interface */
public final class AccountCreationInterface {

    /** Empty constructor */
    private AccountCreationInterface() {
    }

    /** This method provides account creation for user */
    public static AbstractAccount createAccount(final Client currClient) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Bank: ");

        List<String> banks = new ArrayList<>();
        int i = 0;
        for (Bank element : Data.BANKS.values()) {
            System.out.println(element.getBankName() + " (" + (i + 1) + ")");
            banks.add(element.getBankName());
            i++;
        }

        int bank = scanner.nextInt();

        if (bank > i + 1 || bank < 1) {
            System.out.println("Sorry, there is not such a number in brackets.");
            System.exit(0);
        }
        String bankName = banks.get(bank - 1);
        Bank currBank = Data.BANKS.get(bankName);
        System.out.println("Choose account type: debit (1) / credit (2) ");
        String accountValue = scanner.next();
        String accountType = null;
        if (accountValue.equals("1")) {
            accountType = "debit";
        } else if (accountValue.equals("2")) {
            accountType = "credit";
        } else {
            System.out.println("Please, enter only symbols from brackets. Do you want to continue? (y/n)");
            String answer = scanner.next();
            if (answer.equals("y")) {
                System.out.println("Choose account type: debit (1) / credit (2) ");
                accountValue = scanner.next();
                if (accountValue.equals("1")) {
                    accountType = "debit";
                } else if (accountValue.equals("2")) {
                    accountType = "credit";
                } else {
                    System.out.print("Sorry, our program can't understand your requests. ");
                    System.out.println("Please, read README.md to use it.");
                    System.exit(0);
                }

            } else if (answer.equals("n")) {
                System.out.println("Good bye!");
                System.exit(0);
            } else {
                System.out.print("Sorry, our program can't understand your requests. ");
                System.out.println("Please, read README.md to use it.");
                System.exit(0);
            }
        }


        return ClientService.createAccount(bankName, accountType, currClient, currBank);
    }
}
