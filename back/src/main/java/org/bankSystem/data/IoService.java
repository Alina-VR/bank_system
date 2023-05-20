package org.bankSystem.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.bankSystem.account.AbstractAccount;
import org.bankSystem.account.AccountsList;
import org.bankSystem.account.Credit;
import org.bankSystem.account.Debit;
import org.bankSystem.bank.Bank;
import org.bankSystem.bank.BanksList;
import org.bankSystem.client.Client;
import org.bankSystem.client.ClientsList;

/** IO service class */
public final class IoService {
    /** Empty constructor */
    private IoService() {
    }

    /** This method takes clients data from file */
    public static void inputClientsData() {
        File file1 = new File("ClientsData.json");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));

            if (br.readLine() != null) {
                ClientsList clientsList = Converter.toJavaObjectClient();
                List<Client> array1 = clientsList.toClientsArray();

                for (Client client : array1) {
                    Data.RUNTIME_DATA.put(client.getLogin(), client);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** This method takes accounts data from file */
    public static void inputAccountsData() {
        File file2 = new File("AccountsData.json");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file2));

            if (br.readLine() != null) {
                AccountsList accountsList = Converter.toJavaObjectAccount();

                for (Debit debit : accountsList.getDebits()) {
                    Data.ACCOUNT_DATA.put(debit.getId(), debit);
                }
                for (Credit credit : accountsList.getCredits()) {
                    Data.ACCOUNT_DATA.put(credit.getId(), credit);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** This method takes banks data from file */
    public static void inputBanksData() {
        File file3 = new File("BanksData.json");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file3));

            if (br.readLine() != null) {
                BanksList banksList = Converter.toJavaObjectBank();
                List<Bank> array3 = banksList.toBanksArray();

                for (Bank bank : array3) {
                    Data.BANKS.put(bank.getBankName(), bank);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** This method saves clients data to file */
    public static void outputClientsData() {
        List<Client> clients = new ArrayList<>();
        List<String> keys1 = new ArrayList<>(Data.RUNTIME_DATA.keySet());

        for (String key : keys1) {
            Client value = Data.RUNTIME_DATA.get(key);
            clients.add(value);
        }

        try {
            Converter.toJSONClient(new ClientsList(clients));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** This method saves accounts data to file */
    public static void outputAccountsData() {
        List<Credit> credits = new ArrayList<>();
        List<Debit> debits = new ArrayList<>();
        List<String> keys2 = new ArrayList<>(Data.ACCOUNT_DATA.keySet());

        for (String key : keys2) {
            AbstractAccount value = Data.ACCOUNT_DATA.get(key);

            if (value.getAccountType().equals("debit")) {
                debits.add((Debit) value);

            } else {
                credits.add((Credit) value);
            }
        }
        try {
            Converter.toJSONAccount(new AccountsList(debits, credits));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** This method saves banks data to file */
    public static void outputBanksData() {
        List<Bank> banks = new ArrayList<>();
        List<String> keys3 = new ArrayList<>(Data.BANKS.keySet());

        for (String key : keys3) {
            Bank value = Data.BANKS.get(key);
            banks.add(value);
        }

        try {
            Converter.toJSONBank(new BanksList(banks));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
