package org.example;

public class Bank {
    String bankName;
    int creditLimit;
    double fee;

    public Bank(String bankName, int creditLimit, double fee) {
        this.bankName = bankName;
        this.creditLimit = creditLimit;
        this.fee = fee;
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
