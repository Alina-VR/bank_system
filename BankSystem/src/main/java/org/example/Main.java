package org.example;


import lombok.SneakyThrows;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        File file1 = new File("ClientsBase");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file1));
            if (br.readLine() != null) {
                ArrayClientsPOJO arrayClientsPOJO = Converter.toJavaObjectClient();
                List<Client> array1 = arrayClientsPOJO.toClientsArray();
                for (Client client :
                        array1) {
                    Base.runtimeBase.put(client.login, client);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        File file2 = new File("AccountsBase");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file2));
            if (br.readLine() != null) {
                ArrayAccountsPOJO arrayAccountsPOJO = Converter.toJavaObjectAccount();
                List<Account> array2 = arrayAccountsPOJO.toAccountsArray();
                for (Account account:
                        array2) {
                    Base.accountBase.put(account.ID, account);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

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


            List<ClientPOJO> clients = new ArrayList<>();
            List<String> keys1 = new ArrayList<>(Base.runtimeBase.keySet());
            for (String key : keys1) {
                Client value = Base.runtimeBase.get(key);
                clients.add(new ClientPOJO(value));
            }
            Converter.toJSONClient(new ArrayClientsPOJO(clients));

            List<AccountPOJO> accounts = new ArrayList<>();
            List<String> keys2 = new ArrayList<>(Base.accountBase.keySet());
            for (String key : keys2) {
                Account value = Base.accountBase.get(key);
                accounts.add(new AccountPOJO(value));
            }
            Converter.toJSONAccount(new ArrayAccountsPOJO(accounts));

            //System.out.println(Converter.toJavaObject().toString());




            //String clientJson = ConvertJson.convertJsonArray(ConvertJson.convertTheClient(currClient));
//            String clientJson = String.valueOf(ConvertJson.convertTheClient(currClient));
//            IOStream.output(clientJson);
//            String gson = IOStream.input();
//            System.out.println(gson);
//            ArrayClientsPOJO newArray = UnpackJson.getClientJson(gson);
//            List<ClientPOJO> clients = newArray.getClients();
//            List<Client> clients1 = new ArrayList<>();
//            for (ClientPOJO element:
//                 clients) {
//                clients1.add(Client.toClient(element));
//
//            }
//
//            for (Client element:
//                 clients1) {
//                System.out.println(element.login);
//
//            }

            ///Client newClient =  new Client();
            ///ClientPOJO newClientPOJO = UnpackJson.getClientJson(gson);
            ///newClient.login = newClientPOJO.login;
            ///System.out.println(newClient.login);
            System.out.println("Do you want to continue? (yes/no) ");
        }
        System.out.println("Good Bye!");
    }

}
