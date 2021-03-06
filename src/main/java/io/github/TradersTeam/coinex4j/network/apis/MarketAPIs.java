package io.github.TradersTeam.coinex4j.network.apis;

import io.github.TradersTeam.coinex4j.model.*;
import io.github.TradersTeam.coinex4j.model.market.*;
import io.github.TradersTeam.coinex4j.network.util.CallX;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

public interface MarketAPIs {

    String BASE = R.V1 + R.SLASH + R.MARKET + R.SLASH;

    /**
     * Get list of markets
     *
     * @return list of markets
     */
    @GET(BASE + "list")
    CallX<ApiResponse<List<String>>> getMarketsList();

    /**
     * Acquire real-time market data
     *
     * @return market ticker of given market name
     */
    @GET(BASE + R.TICKER)
    CallX<ApiResponse<MarketTicker>> getMarketTicker(@Query("market") String market);

    /**
     * Acquire all market data
     *
     * @return list of all market tickers
     */
    @GET(BASE + R.TICKER + R.SLASH + "all")
    CallX<ApiResponse<MarketTickers>> getMarketTickers();

    /**
     * Acquire buy/sell statistics，return up to 50
     *
     * @param market Required | <a href="https://api.coinex.com/v1/market/list">market list</a>
     * @param merge  Required | '0', '0.1', '0.01', '0.001', '0.0001', '0.00001', '0.000001', '0.0000001', '0.00000001
     * @param limit  Optional | Return amount，range: 5/10/20/50, default 20
     * @return market depth
     */
    @GET(BASE + "depth")
    CallX<ApiResponse<MarketDepth>> getMarketDepth(
            @Query("market") String market,
            @Query("merge") double merge,
            @Nullable @Range(from = 1, to = 50) @Query("limit") Integer limit
    );

    /**
     * Acquire latest transaction data，return up to 1000
     *
     * @param market Required | <a href="https://api.coinex.com/v1/market/list">market list</a>
     * @param lastId Optional | Transaction history id, send 0 to draw from the latest record.
     * @param limit  Optional | Less than or equal to 1000, default 100
     * @return list of latest transaction/deals data
     */
    @GET(BASE + "deals")
    CallX<ApiResponse<List<MarketTransaction>>> getMarketDeals(
            @Query("market") String market,
            @Nullable @Query("last_id") Integer lastId,
            @Nullable @Query("limit") Integer limit);

    /**
     * Acquire k-line data for specified period, including latest 1000 data
     *
     * @param market Required | <a href="https://api.coinex.com/v1/market/list">market list</a>
     * @param limit  Optional | Less than or equal to 1000, default 100
     * @param type   Required | '1min', '3min', '5min', '15min', '30min', '1hour', '2hour', '4hour', '6hour', '12hour', '1day', '1day', '1week'
     * @return list of k-line data
     */
    @GET(BASE + "kline")
    CallX<ApiResponse<List<KLineData>>> getKLineData(
            @Query("market") String market,
            @Query("type") String type,
            @Nullable @Query("limit") Integer limit
    );

    /**
     * Acquire markets detail information
     *
     * @return key value map of market detail information
     */
    @GET(BASE + "info")
    CallX<ApiResponse<Map<String, MarketInfo>>> getMarketsInfo();

    /**
     * Acquire single market detail information
     *
     * @param market single market name
     * @return single market detail information
     */
    @GET(BASE + "detail")
    CallX<ApiResponse<MarketInfo>> getSingleMarketInfo(@Query("market") String market);

    /**
     * Acquire AMM Market List
     *
     * @return list of AMM Market list
     */
    @GET(R.V1 + R.SLASH + "amm/market")
    CallX<ApiResponse<List<String>>> getAmmMarketList();
}
