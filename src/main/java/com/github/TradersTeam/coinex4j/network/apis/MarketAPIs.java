package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.model.MarketTicker;
import com.github.TradersTeam.coinex4j.model.MarketTickers;
import com.github.TradersTeam.coinex4j.network.util.CallX;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface MarketAPIs {

    String SLASH = "/";
    String V1 = "v1/";
    String MARKET = "market/";
    String TICKER = "ticker";

    @GET(V1 + MARKET + "list")
    CallX<ApiResponse<List<String>>> getMarketsList();

    @GET(V1 + MARKET + TICKER)
    CallX<ApiResponse<MarketTicker>> getMarketTicker(@Query("market") String market);

    @GET(V1 + MARKET + TICKER + SLASH + "all")
    CallX<ApiResponse<MarketTickers>> getMarketTickers();
}
