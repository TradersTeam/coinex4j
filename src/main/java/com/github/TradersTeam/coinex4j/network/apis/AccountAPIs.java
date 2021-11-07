package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.AccountAsset;
import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.model.MarketFee;
import com.github.TradersTeam.coinex4j.network.util.CallX;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

import static com.github.TradersTeam.coinex4j.network.apis.MarketAPIs.V1;

public interface AccountAPIs {

    /**
     * Inquire account asset. When the total assets (available + frozen) of a coin are 0, no coin data return.
     * <p></p>
     * <b>This API needs authorization</b>
     *
     * @param tonce Required | The timestamp of the request
     * @return account asset
     */
    @GET(V1 + "balance/info")
    CallX<ApiResponse<Map<String, AccountAsset>>> getBalance(@Query("tonce") Long tonce);

    /**
     * Inquire margin market ID map info.
     *
     * @return map of market names and their ids
     */
    @GET(V1 + "margin/market")
    CallX<ApiResponse<Map<String, String>>> getMarginAccountMarketInfo();

    /**
     * Inquire market fee.
     *
     * @param tonce        Required | The timestamp of the request
     *                     Tonce is a timestamp with a positive Integer that,
     *                     represents the number of milliseconds from Unix epoch to the current time.
     *                     Error between tonce and server time can not exceed plus or minus 60s
     * @param market       Required | The market name
     * @param businessType Optional | use SPOT or PERPETUAL, default to SPOT
     * @return market fee
     */
    @GET(V1 + "account/market/fee")
    CallX<ApiResponse<MarketFee>> getMarketFee(
            @Query("tonce") Long tonce,
            @Query("market") String market,
            @Nullable @Query("business_type") String businessType
    );

    /**
     * calls {@link #getMarketFee(Long, String, String)},
     * with business type set to SPOT
     */
    default CallX<ApiResponse<MarketFee>> getMarketFee(
            @Query("tonce") Long tonce,
            @Query("market") String market
    ) {
        return getMarketFee(tonce, market, null);
    }
}
