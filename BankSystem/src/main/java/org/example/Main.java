package org.example;


import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sign in/ sign up ");
        String sign = scanner.next();
        Client currClient = new Client();
        if (sign.equals("sign in")) {
            currClient = Server.signIn(sign);
        } else if (sign.equals("sign up")) {
            currClient = Server.signUp(sign);
        }

        Server.createAccount(currClient);
        //String currID = currAccount.setID();

    }
}