package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.model.Market;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;
import java.util.Map;

public interface MarketAPIs {
    String SLASH = "/";
    String PERPETUAL_V1 = "perpetual/v1";
    String MARKET = "market";

    @GET(PERPETUAL_V1 + SLASH + MARKET + SLASH + "list")
    Call<ApiResponse<List<Market>>> getMarketList();

    @GET(PERPETUAL_V1 + SLASH + MARKET + SLASH + "limit_config")
    Call<ApiResponse<Map<String, List<List<String>>>>> getMarketLimitConfigList();
}
