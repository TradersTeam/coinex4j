package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.model.Ticker;
import com.github.TradersTeam.coinex4j.network.util.CallX;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface MarketAPIs {
    String V1 = "v1/";
    String MARKET = "market/";

    @GET(V1 + MARKET + "list")
    CallX<ApiResponse<List<String>>> getMarketsList();

    @GET(V1 + MARKET + "ticker")
    CallX<ApiResponse<Ticker>> getMarketTicker(@Query("market") String market);

}
