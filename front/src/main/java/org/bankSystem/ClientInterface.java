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

        Client currClient = clientAuthorization();

        while (!scanner.next().equals("no")) {

            clientWork(currClient);

            Data.saveData("all");
            System.out.println("Do you want to continue? (yes/no) ");
        }
        System.out.println("Good Bye!");
    }

    public static Client clientAuthorization() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose sign_in/ sign_up ");
        String sign = scanner.next();
        Client currClient = new Client();

        if (sign.equals("sign_in")) {
            currClient = Authorization.clientSignIn();

        } else if (sign.equals("sign_up")) {
            currClient = Authorization.clientSignUp();
        }
        Data.saveData("c");
        System.out.println("Continue? (yes/no) ");
        return currClient;
    }

    public static void clientWork(Client currClient) {
        Scanner scanner = new Scanner(System.in);
        if (currClient.getAccounts().size() != 0) {
            System.out.println("There are your accounts here: ");

            for (String element : currClient.getAccounts()) {
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
            AbstractAccount currAbstractAccount = AccountCreationInterface.createAccount(currClient);
            AccountWorkInterface.workWithAccount(currAbstractAccount.getId());

        } else {

            for (String element : Data.ACCOUNT_DATA.keySet()) {
                if (command.equals(element)) {
                    AccountWorkInterface.workWithAccount(element);
                }
            }
        }
    }
}
