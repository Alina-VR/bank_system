package org.bankSystem;

import java.util.Scanner;
import org.bankSystem.account.AbstractAccount;
import org.bankSystem.client.Client;
import org.bankSystem.data.Data;

public final class ClientInterface {

    private ClientInterface() {

    }

    public static void client() {
        Scanner scanner = new Scanner(System.in);

        Client currClient = clientAuthorization(true);

        while (!scanner.next().equals("n")) {

            clientWork(currClient);

            Data.saveData("all");
            System.out.println("Do you want to continue? (y/n) ");
        }
        System.out.println("Good Bye!");
    }

    public static Client clientAuthorization(boolean firstTime) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose: sign_in (1) / sign_up (2)");
        String sign = scanner.next();
        Client currClient = new Client();

        if (sign.equals("1")) {
            currClient = Authorization.clientSignIn();

        } else if (sign.equals("2")) {
            currClient = Authorization.clientSignUp();
        } else {
            System.out.println("Please, enter only symbols from brackets. Do you want to continue? (y/n)");
            String answer = scanner.next();
            if (answer.equals("y")) {
                currClient = clientAuthorization(false);
            } else if (answer.equals("n")) {
                System.out.println("Good bye!");
                System.exit(0);
            } else {
                System.out.println("Please, type y or n.");
                String secondAnswer = scanner.next();
                if (secondAnswer.equals("y")) {
                    currClient = clientAuthorization(false);
                } else if (secondAnswer.equals("n")) {
                    System.out.println("Good bye!");
                    System.exit(0);
                } else {
                    System.out.print("Sorry, our program can't understand your requests. ");
                    System.out.println("Please, read README.md to use it.");
                    System.exit(0);
                }
            }
        }
        Data.saveData("c");
        if (firstTime) {
            System.out.println("Continue? (y/n) ");
        }
        return currClient;
    }

    public static void clientWork(Client currClient) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        if (currClient.getAccounts().size() != 0) {
            System.out.println("There are your accounts here: ");
            for (String element : currClient.getAccounts()) {
                System.out.println(element + " (" + (i + 1) + ")");
                i++;
            }
            System.out.println("Choose account or create a new one.");

        } else {
            System.out.println("You have not got any accounts yet.");
        }

        System.out.println("If you want to create a new one enter 'create'.");
        System.out.println("If you want to escape enter 'bye'.");
        String answer = scanner.next();

        if (answer.equals("create")) {
            AbstractAccount currAbstractAccount = AccountCreationInterface.createAccount(currClient);
            AccountWorkInterface.workWithAccount(currAbstractAccount.getId());

        } else if (answer.equals("bye")) {
            System.out.println("Good bye!");
            System.exit(0);
        } else {
            if (Integer.parseInt(answer) > i || Integer.parseInt(answer) < 1) {
                System.out.println("Sorry, there is not such a number in brackets.");
                System.exit(0);
            }
            String command = currClient.getAccounts().get(Integer.parseInt(answer) - 1);

            for (String element : Data.ACCOUNT_DATA.keySet()) {
                if (command.equals(element)) {
                    AccountWorkInterface.workWithAccount(element);
                }
            }
        }
    }
}
