package org.example;

public class Bank {
    static String bankName;
    int creditLimit;
    double fee;

    public Bank() {
        this.bankName = "Bank";
        this.creditLimit = 1000000;
        this.fee = 0.05;
    }
    public int setBankID(String bankName){
        return 0;
    }
    public Debit debit(){
        Debit debit = new Debit();
        return debit;
    }
    public Credit credit(){
        Credit credit = new Credit();
        return credit;
    }
}
