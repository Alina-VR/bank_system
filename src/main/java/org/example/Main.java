package org.example;

import java.util.Scanner;
import org.example.account.AbstractAccount;
import org.example.bank.Bank;
import org.example.bank.BankService;
import org.example.client.Client;
import org.example.client.ClientService;
import org.example.data.Data;
import org.example.data.IoService;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {
        IoService.inputClientsData();
        IoService.inputAccountsData();
        IoService.inputBanksData();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the BankSystem!");
        System.out.println("Do you want to continue as a bank or as a customer?");
        String roleChoice = scanner.next();
        if (roleChoice.equals("customer")) {
            System.out.println("Choose sign_in/ sign_up ");
            String sign = scanner.next();
            Client currClient = new Client();

            if (sign.equals("sign_in")) {
                currClient = ClientService.signIn();

            } else if (sign.equals("sign_up")) {
                currClient = ClientService.signUp();
            }
            IoService.outputClientsData();
            System.out.println("Continue? (yes/no) ");

            while (!scanner.next().equals("no")) {
                if (currClient.getAccounts().size() != 0) {
                    System.out.println("There are your accounts here: ");

                    for (String element : currClient.getAccounts()) {
                        System.out.println(element);
                    }
                    System.out.println("Choose account or create a new one");
                    System.out.println("If you want to choose any account" + " enter it's name from the list");

                } else {
                    System.out.println("You have not got any accounts yet");
                }

                System.out.println("If you want to create a new one enter 'create'");

                String command = scanner.next();

                if (command.equals("create")) {
                    AbstractAccount currAbstractAccount = ClientService.createAccount(currClient);
                    ClientService.workWithAccount(currAbstractAccount.getId(), currClient);

                } else {

                    for (String element : Data.ACCOUNT_DATA.keySet()) {
                        if (command.equals(element)) {
                            ClientService.workWithAccount(element, currClient);
                        }
                    }
                }
                IoService.outputClientsData();
                IoService.outputAccountsData();
                IoService.outputBanksData();
                System.out.println("Do you want to continue? (yes/no) ");
            }
            System.out.println("Good Bye!");
        } else if (roleChoice.equals("bank")) {

            System.out.println("Choose sign_in/ sign_up ");
            String sign = scanner.next();
            Bank currBank = new Bank();

            if (sign.equals("sign_in")) {
                currBank = BankService.signIn();

            } else if (sign.equals("sign_up")) {
                currBank = BankService.signUp();
            }
            IoService.outputBanksData();
            System.out.println("Continue? (yes/no) ");

            while (!scanner.next().equals("no")) {
                System.out.println("Do you want to see the accounts list (1) "
                        + "or information about bank (2)? Type 1 or 2");
                if (scanner.nextInt() == 1) {
                    BankService.seeAccounts(currBank);
                } else {
                    BankService.seeInformation(currBank);
                }
                IoService.outputBanksData();
                System.out.println("Continue? (yes/no) ");
            }
            System.out.println("Good Bye!");
        }
    }
}


