package org.example;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Base.addBanks();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sign_in/ sign_up ");
        String sign = scanner.next();
        Client currClient = new Client();
        if (sign.equals("sign_in")) {
            currClient = ClientServer.signIn();
        } else if (sign.equals("sign_up")) {
            currClient = ClientServer.signUp();
        }
        System.out.println("Continue? (yes/no) ");
        while (!scanner.next().equals("no")) {
            System.out.println("There are your accounts here: ");
            if (currClient.accounts != null) {
                for (String element : currClient.accounts) {
                    System.out.println(element);
                }
                System.out.println("Choose account or create a new one");
                System.out.println("If you want to choose any account enter it's name from the list");
            } else {
                System.out.println("You have not got any accounts yet");
            }
            System.out.println("If you want to create a new one enter 'create'");
            String command = scanner.next();
            if (command.equals("create")) {
                Account currAccount = ClientServer.createAccount(currClient);
                ClientServer.workWithAccount(currAccount.ID, currClient);
            } else {
                for (String element : Base.accountBase.keySet()) {
                    if (command.equals(element)) {
                        ClientServer.workWithAccount(element, currClient);
                    }
                }
            }
            System.out.println("Do you want to continue? (yes/no) ");
        }
        System.out.println("Good Bye!");
    }
}
