package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Base {
    //static HashMap<String, Client> base = new HashMap<>();
    static HashMap<String, Client> runtimeBase = new HashMap<>();
    static HashMap<String, Account> accountBase = new HashMap<>();
    static ArrayList<Bank> banks = new ArrayList<>();


    public static void addBanks(){   /// no sense, we have a fixed list of banks
        banks.add(BankMaker.firstBank); /// we can add this option later when we will create bank controller
        banks.add(BankMaker.secondBank);
        banks.add(BankMaker.thirdBank);
    }

}
