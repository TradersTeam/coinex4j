package com.github.TradersTeam.coinex4j.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utility {

    private static Gson gson = null;

    public static String objectToJson(Object object) {
        if (gson == null) gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(object);
    }
}
