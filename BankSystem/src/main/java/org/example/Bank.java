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
    public Debit debit(int balance,String login,String bankName,String accountType){
        Debit debit = new Debit(balance,login,bankName,accountType);
        return debit;
    }
    public Credit credit(int balance,String login,String bankName,String accountType){
        Credit credit = new Credit(balance,login,bankName,accountType);
        credit.creditLimit = creditLimit;
        credit.fee = fee;
        return credit;
    }
}
