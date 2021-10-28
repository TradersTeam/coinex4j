package com.github.TradersTeam.coinex4j.util;

import com.google.gson.Gson;

public class Utility {

    private static Gson gson = null;

    public static String objectToJson(Object object) {
        if (gson == null) gson = new Gson();
        return gson.toJson(object);
    }
}
