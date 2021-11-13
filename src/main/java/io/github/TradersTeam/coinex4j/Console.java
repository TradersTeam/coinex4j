package io.github.TradersTeam.coinex4j;

import io.github.TradersTeam.coinex4j.network.CoinEx4J;
import io.github.TradersTeam.coinex4j.network.apis.PerpetualAPIs;

public class Console {
    public static void main(String... args) {
        CoinEx4J coinEx4J = new CoinEx4J.Builder()
                .autoShutDown(true)
                .build();

        var call = coinEx4J.createAPI(PerpetualAPIs.Market.class).getMarketList();
        call.asyncBody(coinEx4J, (response, throwable) -> {
            if (response != null && throwable == null) {
                System.out.println(response.data());
            } else {
                System.out.println(throwable.getMessage());
            }
        });
    }
}
