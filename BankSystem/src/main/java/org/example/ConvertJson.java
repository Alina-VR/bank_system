package org.example;

import com.google.gson.Gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class ConvertJson {


    JsonArray jsonArray = new JsonArray();
    public static ClientPojo getClient(Client client) {
        ClientPojo clientPojo = new ClientPojo();
        clientPojo.setUserName(client.userName); // need arguments
        clientPojo.setUserSurname(client.userSurname);
        clientPojo.setAddress(client.address);
        clientPojo.setPassport(client.passport);
        clientPojo.setLogin(client.login);
        clientPojo.setPassword(client.password);
        clientPojo.setAccounts(client.accounts);

        return clientPojo;
    }
    public static String convertJson(Client client) {
        ClientPojo clientPojo = getClient(client);
        String clientJson = new Gson().toJson(clientPojo);
        return clientJson;
    }

    public static String convertJsonArray(ClientPojo clientPojo, String clientJson) {
        String ID = String.valueOf(clientPojo.getLogin());
        JsonObject clientsJson = new JsonObject();
        clientsJson.addProperty(ID, clientJson);
        return clientsJson.toString();


    }
}