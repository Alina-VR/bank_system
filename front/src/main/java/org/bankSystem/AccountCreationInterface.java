package org.bankSystem;

import java.util.Scanner;
import org.bankSystem.account.AbstractAccount;
import org.bankSystem.bank.Bank;
import org.bankSystem.client.Client;
import org.bankSystem.client.ClientService;
import org.bankSystem.data.Data;

public final class AccountCreationInterface {

    private AccountCreationInterface() {
    }

    public static AbstractAccount createAccount(final Client currClient) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose Bank: ");

        for (Bank element : Data.BANKS.values()) {
            System.out.println(element.getBankName());
        }

        String bankName = scanner.next();
        Bank currBank = Data.BANKS.get(bankName);
        System.out.println("Choose account type (debit/credit): ");
        String accountType = scanner.next();

        return ClientService.createAccount(bankName, accountType, currClient, currBank);
    }
}
