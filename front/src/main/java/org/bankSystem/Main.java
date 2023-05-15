package org.bankSystem;

import org.bankSystem.data.Data;

public final class Main {
    private Main() {
    }

    public static void main(final String[] args) {

        Data.takeData();

        MainService.start();
    }
}
