package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.*;
import com.github.TradersTeam.coinex4j.model.perpetual.*;
import com.github.TradersTeam.coinex4j.network.util.CallX;
import org.jetbrains.annotations.Range;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

public interface PerpetualAPIs {
    String PERPETUAL_V1 = "perpetual/v1/";
    String MARKET = "market/";

    interface System {

        /**
         * Test API for checking server status
         *
         * @return "pong"
         */
        @GET(PERPETUAL_V1 + "ping")
        CallX<ApiResponse<String>> getPing();

        /**
         * Get server time
         *
         * @return Server time in milliseconds
         */
        @GET(PERPETUAL_V1 + "time")
        CallX<ApiResponse<DateTime>> getTime();
    }

    /**
     * Get perpetual market list
     *
     * @return List of perpetual market
     */
    @GET(PERPETUAL_V1 + MARKET + "list")
    CallX<ApiResponse<List<PerpetualMarket>>> getMarketList();

    /**
     * Get perpetual market limit config
     *
     * @return map of markets and their limit config
     */
    @GET(PERPETUAL_V1 + MARKET + "limit_config")
    CallX<ApiResponse<Map<String, List<PerpetualLimitConfig>>>> getMarketLimitConfigList();

    /**
     * Get single market ticker info
     *
     * @param market market name
     * @return market ticker info
     */
    @GET(PERPETUAL_V1 + MARKET + "ticker")
    CallX<ApiResponse<PerpetualMarketTicker>> getMarketTicker(@Query("market") String market);

    /**
     * Get all markets ticker info
     *
     * @return map of market ticker info and current time
     */
    @GET(PERPETUAL_V1 + MARKET + "ticker" + "/all")
    CallX<ApiResponse<PerpetualMarketTickers>> getMarketTickers();

    /**
     * Get market depth info
     *
     * @param market market name
     * @param merge  merge precision, take one of the value among "10", "1", "0", "0.1" and "0.01".
     * @param limit  the number of entries obtained, take one of the value among 5, 10, 20, 50 and 100.
     * @return market depth info
     */
    @GET(PERPETUAL_V1 + MARKET + "depth")
    CallX<ApiResponse<MarketDepth>> getMarketDepth(
            @Query("market") String market, @Query("merge") double merge, @Range(from = 1, to = 50) @Query("limit") int limit
    );
}
