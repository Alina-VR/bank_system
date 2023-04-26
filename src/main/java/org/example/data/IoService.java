package org.example.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.example.account.AbstractAccount;
import org.example.account.AccountsList;
import org.example.account.Credit;
import org.example.account.Debit;
import org.example.bank.Bank;
import org.example.bank.BanksList;
import org.example.client.Client;
import org.example.client.ClientsList;

public final class IoService {
    private IoService() {
    }

    public static void inputClientsData() {
        File file1 = new File(Objects.requireNonNull(
                Converter.class.getResource("/ClientsData.json")).getFile());

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

    public static void inputAccountsData() {
        File file2 = new File(Objects.requireNonNull(
                Converter.class.getResource("/AccountsData.json")).getFile());

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

    public static void inputBanksData() {
        File file3 = new File(Objects.requireNonNull(
                Converter.class.getResource("/BanksData.json")).getFile());

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


