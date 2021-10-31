package com.github.TradersTeam.coinex4j.util;

import com.github.TradersTeam.coinex4j.model.*;
import com.github.TradersTeam.coinex4j.model.adapters.DateTimeAdapter;
import com.github.TradersTeam.coinex4j.model.perpetual.adapters.PerpetualLimitConfigAdapter;
import com.github.TradersTeam.coinex4j.model.perpetual.adapters.PerpetualMarketDepthItemAdapter;
import com.github.TradersTeam.coinex4j.model.perpetual.PerpetualLimitConfig;
import com.github.TradersTeam.coinex4j.model.perpetual.PerpetualMarketDepthItem;
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
            gsonBuilder.registerTypeAdapter(PerpetualLimitConfig.class, new PerpetualLimitConfigAdapter())
                    .registerTypeAdapter(DateTime.class, new DateTimeAdapter())
                    .registerTypeAdapter(PerpetualMarketDepthItem.class, new PerpetualMarketDepthItemAdapter());
            gson = gsonBuilder.create();
        }
        return gson;
    }
}
