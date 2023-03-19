package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Converter {

    private final static String baseFile1 = "ClientsBase";
    private final static String baseFile2 = "AccountsBase";

    public static void toJSONClient(ArrayClientsPOJO arrayClientsPOJO) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile1), arrayClientsPOJO);
        System.out.println("json created!");
    }

    public static ArrayClientsPOJO toJavaObjectClient() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile1), ArrayClientsPOJO.class);
    }

    public static void toJSONAccount(ArrayAccountsPOJO arrayAccountsPOJOPOJO) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile2), arrayAccountsPOJOPOJO);
        System.out.println("json created!");
    }

    public static ArrayAccountsPOJO toJavaObjectAccount() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile2), ArrayAccountsPOJO.class);
    }
}