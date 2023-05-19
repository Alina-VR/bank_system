package org.bankSystem;

import org.bankSystem.data.Data;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {

        System.out.println("Welcome to the BankSystem!");

        Data.takeData();

        MainService.start();
    }
}
