package org.example;

import com.google.gson.JsonObject;

public class ConvertToJSON {
    static JsonObject convertedClient = new JsonObject();

    public static String convert(Client currClient) {

        JsonObject keyValue = new JsonObject();
        keyValue.addProperty("UserName", currClient.userName);
        keyValue.addProperty("UserSurname", currClient.userSurname);
        keyValue.addProperty("address", currClient.address);
        keyValue.addProperty("passport", currClient.passport);
        keyValue.addProperty("login", currClient.login);
        keyValue.addProperty("password", currClient.password);

        JsonObject client = new JsonObject();
        client.addProperty(currClient.login, keyValue.toString());
        convertedClient = client;
        return convertedClient.toString();
    }
}
