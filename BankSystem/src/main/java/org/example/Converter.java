package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Converter {

    private final static String baseFile = "ClientsBase";

    public static void toJSON(ArrayClientsPOJO arrayClientsPOJO) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), arrayClientsPOJO);
        System.out.println("json created!");
    }

    public static ArrayClientsPOJO toJavaObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), ArrayClientsPOJO.class);
    }
}

///import com.google.gson.*;
///public class ConvertJson {



//    JsonArray jsonArray = new JsonArray();
//
//    public static JsonObject convertTheClient(AbstractClient client) {
//        ClientPOJO currClient = new ClientPOJO(client);
//        JsonObject keyValue = new JsonObject();
//
//
//        Data data = gson.fromJson(this.json, Data.class);
//
//
//        JsonObject convertedClient = new JsonObject();
//        convertedClient.addProperty(currClient.login, String.valueOf(keyValue));
//        return convertedClient;
//    }
//
//    public static String convertJsonArray(JsonObject convertedClient) {
//
//        JsonArray array = new JsonArray();
//        array.add(convertedClient);
//        ///return array.toString();
//        JsonObject finalJson = new JsonObject();
//        finalJson.addProperty("clients", String.valueOf(array));
//        return finalJson.toString();
//
//    }
//}