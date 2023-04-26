package org.example.bank;

import java.util.Scanner;
import org.example.data.Data;

public final class BankService {

    private BankService() { }

    public static Bank signIn() {
        Scanner scanner = new Scanner(System.in);
        Bank currBank;
        System.out.println("BankName: ");
        String bankName = scanner.next();

        currBank = Data.BANKS.get(bankName);
        System.out.println("Registration ID: ");
        String registrationID = scanner.next();

        if (!registrationID.equals(currBank.getRegistrationID())) {
            System.out.println("Registration ID: ");
            String secondRegistrationID = scanner.next();

            if (!secondRegistrationID.equals(currBank.getRegistrationID())) {
                System.out.println("Access denied");
                System.exit(1);
            }
        }
        return currBank;
    }

    public static Bank signUp() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bank name: ");
        String bankName = scanner.next();

        System.out.println("Registration ID: ");
        String registrationID = scanner.next();

        System.out.println("Credit Limit: ");
        int creditLimit = scanner.nextInt();

        System.out.println("Fee: ");
        double fee = scanner.nextDouble();

        Bank currBank = new Bank(bankName, registrationID, creditLimit, fee);
        Data.BANKS.put(currBank.getBankName(), currBank);
        return currBank;
    }

    public static void seeInformation(Bank bank) {
        System.out.println("bank: " + bank.getBankName());
        System.out.println("registration number: " + bank.getRegistrationID());
        System.out.println("credit limit: " + bank.getCreditLimit());
        System.out.println("fee: " + bank.getFee());
    }

    public static void seeAccounts(Bank bank) {
        for (String account: bank.getAccounts()) {
            System.out.println(account);
        }
    }
}

