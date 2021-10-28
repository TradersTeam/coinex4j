package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.model.LimitConfig;
import com.github.TradersTeam.coinex4j.model.Market;
import com.github.TradersTeam.coinex4j.model.MarketTicker;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

public interface MarketAPIs {
    String PERPETUAL_V1 = "perpetual/v1/";
    String MARKET = "market/";

    @GET(PERPETUAL_V1 + MARKET + "list")
    Call<ApiResponse<List<Market>>> getMarketList();

    @GET(PERPETUAL_V1 + MARKET + "limit_config")
    Call<ApiResponse<Map<String, List<LimitConfig>>>> getMarketLimitConfigList();

    @GET(PERPETUAL_V1 + MARKET + "ticker")
    Call<ApiResponse<MarketTicker>> getMarketTicker(@Query("market") String market);
}
