package com.github.TradersTeam.coinex4j;

import com.github.TradersTeam.coinex4j.network.AsyncResponse;
import com.github.TradersTeam.coinex4j.network.CoinEx4J;
import com.github.TradersTeam.coinex4j.network.apis.GeneralAPIs;

public class Console {
    public static void main(String... args) {
        CoinEx4J coinEx4J = new CoinEx4J.Builder()
                .createDefaultInstance()
                .build();

        var call = coinEx4J.getRetrofit().create(GeneralAPIs.class).getMarketList();
        var asyncResponse = new AsyncResponse<>(call, coinEx4J);
        asyncResponse.async((response, throwable) -> {
            if (response != null && throwable == null) {
                System.out.println(response.getData());
            } else {
                System.out.println(throwable.getMessage());
            }
        });
    }
}
