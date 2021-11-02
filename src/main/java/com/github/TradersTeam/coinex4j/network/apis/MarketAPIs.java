package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.*;
import com.github.TradersTeam.coinex4j.network.util.CallX;
import org.jetbrains.annotations.Range;
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

    /**
     * Acquire real-time market data
     */
    @GET(V1 + MARKET + TICKER)
    CallX<ApiResponse<MarketTicker>> getMarketTicker(@Query("market") String market);

    /**
     * acquire all market data
     */
    @GET(V1 + MARKET + TICKER + SLASH + "all")
    CallX<ApiResponse<MarketTickers>> getMarketTickers();

    /**
     * Acquire buy/sell statistics，return up to 50
     *
     * @param market <a href="https://api.coinex.com/v1/market/list">market list</a>
     * @param merge  0', '0.1', '0.01', '0.001', '0.0001', '0.00001', '0.000001', '0.0000001', '0.00000001
     * @param limit  Return amount，range: 5/10/20/50, default 20
     * @return market depth
     */
    @GET(V1 + MARKET + "depth")
    CallX<ApiResponse<MarketDepth>> getMarketDepth(
            @Query("market") String market, @Query("merge") double merge, @Range(from = 1, to = 50) @Query("limit") int limit
    );

    @GET(V1 + MARKET + "deals")
    CallX<ApiResponse<List<MarketTransaction>>> getMarketDeals(@Query("market") String market);
}
