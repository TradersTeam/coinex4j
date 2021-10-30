package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.*;
import com.github.TradersTeam.coinex4j.network.util.CallX;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

public interface PerpetualAPIs {
    String PERPETUAL_V1 = "perpetual/v1/";
    String MARKET = "market/";

    interface System {
        @GET(PERPETUAL_V1 + "ping")
        CallX<ApiResponse<String>> getPing();

        @GET(PERPETUAL_V1 + "time")
        CallX<ApiResponse<DateTime>> getTime();
    }

    @GET(PERPETUAL_V1 + MARKET + "list")
    CallX<ApiResponse<List<Market>>> getMarketList();

    @GET(PERPETUAL_V1 + MARKET + "limit_config")
    CallX<ApiResponse<Map<String, List<LimitConfig>>>> getMarketLimitConfigList();

    @GET(PERPETUAL_V1 + MARKET + "ticker")
    CallX<ApiResponse<MarketTicker>> getMarketTicker(@Query("market") String market);

    @GET(PERPETUAL_V1 + MARKET + "ticker" + "/all")
    CallX<ApiResponse<MarketTickers>> getMarketTickers();

    @GET(PERPETUAL_V1 + MARKET + "depth")
    CallX<ApiResponse<MarketDepth>> getMarketDepth(
            @Query("market") String market, @Query("merge") Double merge, @Query("limit") int limit
    );
}
