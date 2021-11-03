package com.github.TradersTeam.coinex4j.util;

import com.github.TradersTeam.coinex4j.model.DateTime;
import com.github.TradersTeam.coinex4j.model.KLineData;
import com.github.TradersTeam.coinex4j.model.MarketDepthItem;
import com.github.TradersTeam.coinex4j.model.MarketTransactionType;
import com.github.TradersTeam.coinex4j.model.adapters.DateTimeAdapter;
import com.github.TradersTeam.coinex4j.model.adapters.KLineDataAdapter;
import com.github.TradersTeam.coinex4j.model.adapters.MarketDepthItemAdapter;
import com.github.TradersTeam.coinex4j.model.adapters.MarketTransactionTypeAdapter;
import com.github.TradersTeam.coinex4j.model.perpetual.PerpetualLimitConfig;
import com.github.TradersTeam.coinex4j.model.perpetual.adapters.PerpetualLimitConfigAdapter;
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
                    .registerTypeAdapter(MarketDepthItem.class, new MarketDepthItemAdapter())
                    .registerTypeAdapter(MarketTransactionType.class, new MarketTransactionTypeAdapter())
                    .registerTypeAdapter(KLineData.class, new KLineDataAdapter());
            gson = gsonBuilder.create();
        }
        return gson;
    }
}
