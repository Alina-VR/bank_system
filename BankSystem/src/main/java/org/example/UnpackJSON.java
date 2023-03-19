package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

public class UnpackJSON {
        static HashMap<String, Client> base = new Gson().fromJson(
                IOStream.arrayJsonTxt, new TypeToken<HashMap<String, Object>>() {
                }.getType()
        );
}
