package org.example.data;

import java.util.HashMap;
import java.util.Map;
import org.example.account.AbstractAccount;
import org.example.bank.Bank;
import org.example.client.Client;

public final class Data {
    public static final Map<String, Client> RUNTIME_DATA = new HashMap<>();
    public static final Map<String, AbstractAccount> ACCOUNT_DATA = new HashMap<>();
    public static final Map<String, Bank> BANKS = new HashMap<>();

    private Data() {
    }

//    public static void addBanks() {
//        BANKS.add(BankMaker.FIRST_BANK);
//        BANKS.add(BankMaker.SECOND_BANK);
//        BANKS.add(BankMaker.THIRD_BANK);
//    }
}




