package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.*;
import com.github.TradersTeam.coinex4j.model.perpetual.*;
import com.github.TradersTeam.coinex4j.network.util.CallX;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

public interface PerpetualAPIs {

    String BASE = R.PERPETUAL + R.SLASH + R.V1 + R.SLASH;
    String BASE_MARKET = BASE + R.MARKET + R.SLASH;

    interface System {

        /**
         * Test API for checking server status
         *
         * @return "pong"
         */
        @GET(BASE + "ping")
        CallX<ApiResponse<String>> getPing();

        /**
         * Get server time
         *
         * @return Server time in milliseconds
         */
        @GET(BASE + "time")
        CallX<ApiResponse<DateTime>> getTime();
    }

    interface Market {

        /**
         * Get perpetual market list
         *
         * @return List of perpetual market
         */
        @GET(BASE_MARKET + "list")
        CallX<ApiResponse<List<PerpetualMarket>>> getMarketList();

        /**
         * Get perpetual market limit config
         *
         * @return map of markets and their limit config
         */
        @GET(BASE_MARKET + "limit_config")
        CallX<ApiResponse<Map<String, List<PerpetualLimitConfig>>>> getMarketLimitConfigList();

        /**
         * Get single market ticker info
         *
         * @param market perpetual market name
         * @return market ticker info
         */
        @GET(BASE_MARKET + "ticker")
        CallX<ApiResponse<PerpetualMarketTicker>> getMarketTicker(@Query("market") String market);

        /**
         * Get all markets ticker info
         *
         * @return map of market ticker info and current time
         */
        @GET(BASE_MARKET + "ticker" + "/all")
        CallX<ApiResponse<PerpetualMarketTickers>> getMarketTickers();

        /**
         * Get market depth info
         *
         * @param market perpetual market name
         * @param merge  merge precision, take one of the value among "10", "1", "0", "0.1" and "0.01".
         * @param limit  the number of entries obtained, take one of the value among 5, 10, 20, 50 and 100.
         * @return market depth info
         */
        @GET(BASE_MARKET + "depth")
        CallX<ApiResponse<MarketDepth>> getMarketDepth(
                @Query("market") String market, @Query("merge") double merge, @Range(from = 1, to = 50) @Query("limit") int limit
        );

        /**
         * Acquire latest perpetual transaction data，return up to 1000
         *
         * @param market Required | perpetual market name
         * @param lastId Optional | Transaction history id, send 0 to draw from the latest record.
         * @param limit  Optional | Less than or equal to 1000, default 100
         * @return list of latest transaction/deals data
         */
        @GET(BASE_MARKET + "deals")
        CallX<ApiResponse<List<MarketTransaction>>> getMarketDeals(
                @Query("market") String market,
                @Nullable @Query("last_id") Integer lastId,
                @Nullable @Query("limit") Integer limit);

        /**
         * Get Perpetual market funding history
         *
         * @param market    Required | perpetual market name
         * @param offset    Required
         * @param limit     Required
         * @param startTime Optional
         * @param endTime   Optional
         * @return funding history of given market
         */
        @GET(BASE_MARKET + "funding_history")
        CallX<ApiResponse<MarketFundingHistory>> getMarketFundingHistory(
                @Query("market") String market,
                @Query("offset") Integer offset,
                @Query("limit") Integer limit,
                @Nullable @Query("start_time") Integer startTime,
                @Nullable @Query("end_time") Integer endTime);

        /**
         * Get perpetual market KLine data
         *
         * @param market Required | perpetual market name
         * @param type   Required | Supported candlestick parameters:
         *               1min, 3min, 5min, 15min, 30min, 1hour, 2hour, 4hour, 6hour, 12hour, 1day, 3day, 1week
         * @param limit  Optional | The number of candlesticks obtained must not be greater than 1000 (1000 by default)
         * @return KLine data
         */
        @GET(BASE_MARKET + "kline")
        CallX<ApiResponse<List<KLineData>>> getKLineData(
                @Query("market") String market,
                @Query("type") String type,
                @Nullable @Query("limit") Integer limit
        );
    }
}
