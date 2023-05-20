package org.bankSystem.data;

import java.util.HashMap;
import java.util.Map;
import org.bankSystem.account.AbstractAccount;
import org.bankSystem.bank.Bank;
import org.bankSystem.client.Client;

/** Data class */
public final class Data {
    /** Hash map with clients */
    public static final Map<String, Client> RUNTIME_DATA = new HashMap<>();
    /** Hash map with accounts */
    public static final Map<String, AbstractAccount> ACCOUNT_DATA = new HashMap<>();
    /** Hash map with banks */
    public static final Map<String, Bank> BANKS = new HashMap<>();

    /** Constructor */
    private Data() {
    }

    /** This method takes data from files */
    public static void takeData() {
        IoService.inputClientsData();
        IoService.inputAccountsData();
        IoService.inputBanksData();
    }

    /** This method save data in files */
    public static void saveData(String arg) {
        if (arg.equals("all")) {
            IoService.outputClientsData();
            IoService.outputAccountsData();
            IoService.outputBanksData();
        } else if (arg.equals("c")) {
            IoService.outputClientsData();
        } else if (arg.equals("a")) {
            IoService.outputAccountsData();
        } else if (arg.equals("b")) {
            IoService.outputBanksData();
        }
    }
}
