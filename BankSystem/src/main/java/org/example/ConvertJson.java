package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


public class ConvertJson {


    JsonArray jsonArray = new JsonArray();

    public static JsonObject convertTheClient(AbstractClient currClient) {
        //JsonArray array = new JsonArray(7);
        JsonObject keyValue = new JsonObject();
        keyValue.addProperty("UserName", currClient.userName);
        keyValue.addProperty("UserSurname", currClient.userSurname);
        keyValue.addProperty("address", currClient.address);
        keyValue.addProperty("passport", currClient.passport);
        keyValue.addProperty("login", currClient.login);
        keyValue.addProperty("password", currClient.password);
        //TODO accounts
        ///keyValue.addProperty("accounts", currClient.accounts)
//        JsonArray accountsJson = new JsonArray();
//        currClient.accounts {
//
//        }


        JsonObject convertedClient = new JsonObject();
        convertedClient.addProperty(currClient.login, keyValue.toString());
        return convertedClient;
    }

    public static String convertJsonArray(JsonObject convertedClient) {

        JsonArray array = new JsonArray();
        array.add(convertedClient);
        return array.toString();

    }
}