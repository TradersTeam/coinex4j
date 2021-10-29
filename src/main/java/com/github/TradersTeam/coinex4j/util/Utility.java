package com.github.TradersTeam.coinex4j.util;

import com.github.TradersTeam.coinex4j.model.*;
import com.github.TradersTeam.coinex4j.model.adapters.DateTimeAdapter;
import com.github.TradersTeam.coinex4j.model.adapters.LimitConfigAdapter;
import com.github.TradersTeam.coinex4j.model.adapters.MarketDepthItemAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utility {

    private static Gson gson = null;

    public static String objectToJson(Object object) {
        return getGson().toJson(object);
    }

    public static Gson getGson() {
        if (gson == null) {
            GsonBuilder gsonBuilder = new GsonBuilder().setPrettyPrinting();
            gsonBuilder.registerTypeAdapter(LimitConfig.class, new LimitConfigAdapter())
                    .registerTypeAdapter(DateTime.class, new DateTimeAdapter())
                    .registerTypeAdapter(MarketDepthItem.class, new MarketDepthItemAdapter());
            gson = gsonBuilder.create();
        }
        return gson;
    }
}
