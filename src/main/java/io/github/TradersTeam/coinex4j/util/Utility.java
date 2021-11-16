package io.github.TradersTeam.coinex4j.util;

import io.github.TradersTeam.coinex4j.model.DateTime;
import io.github.TradersTeam.coinex4j.model.market.KLineData;
import io.github.TradersTeam.coinex4j.model.market.MarketDepthItem;
import io.github.TradersTeam.coinex4j.model.market.MarketTransactionType;
import io.github.TradersTeam.coinex4j.model.adapters.DateTimeAdapter;
import io.github.TradersTeam.coinex4j.model.adapters.KLineDataAdapter;
import io.github.TradersTeam.coinex4j.model.adapters.MarketDepthItemAdapter;
import io.github.TradersTeam.coinex4j.model.adapters.MarketTransactionTypeAdapter;
import io.github.TradersTeam.coinex4j.model.perpetual.PerpetualLimitConfig;
import io.github.TradersTeam.coinex4j.model.perpetual.adapters.PerpetualLimitConfigAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Utility {

    private static Gson gson = null;

    /**
     * convert object to json string
     *
     * @param object object to convert
     * @return json string
     */
    public static String objectToJson(Object object) {
        return getGson().toJson(object);
    }

    /**
     * create Gson object if it is not created yet
     *
     * @return Gson object
     */
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

    /**
     * create MD5 checksum from input string
     *
     * @param input string to create checksum from
     * @return MD5 checksum of input string
     */
    public static String MD5(String input) {
        try {
            var messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(input.getBytes(StandardCharsets.UTF_8));
            byte[] digest = messageDigest.digest();
            return byteToHexString(digest).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception while hashing: " + e.getMessage());
        }
        return null;
    }

    public static long getCurrentMillis() {
        return LocalDateTime.now(ZoneOffset.UTC).toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    private static String byteToHexString(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }
}
