package io.github.TradersTeam.coinex4j.network.apis;

import io.github.TradersTeam.coinex4j.model.ApiResponse;
import io.github.TradersTeam.coinex4j.model.account.AccountAsset;
import io.github.TradersTeam.coinex4j.model.account.CreditAccount;
import io.github.TradersTeam.coinex4j.model.market.MarketFee;
import io.github.TradersTeam.coinex4j.network.util.CallX;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

public interface AccountAPIs {

    String BASE_BALANCE = R.BASE_V1 + R.BALANCE + R.SLASH;

    /**
     * Inquire account asset. When the total assets (available + frozen) of a coin are 0, no coin data return.
     * <p></p>
     * <b>This API needs authorization</b>
     *
     * @param tonce Required | The timestamp of the request
     * @return account asset
     */
    @GET(BASE_BALANCE + "info")
    CallX<ApiResponse<Map<String, AccountAsset>>> getBalance(@Query("tonce") Long tonce);

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
    @GET(R.BASE_V1 + "account/market/fee")
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

    /**
     * Inquire withdrawal list.
     * <p></p>
     * <b>This API needs authorization</b>
     *
     * @param tonce          Required | The timestamp of the request
     * @param coinType       Optional | Coin type, e.g. BCH. Filter its withdrawal list when the parameter is passed.
     * @param coinWithdrawId Optional | Coin withdrawal id. Search its withdrawal record when the parameter is passed.
     * @param page           Optional | Page, start from 1
     * @param limit          Optional | Amount per page(1-100)
     * @return withdrawal list
     */
    @ApiStatus.Experimental
    @GET(BASE_BALANCE + "coin/withdraw")
    CallX<ApiResponse<List<Map<String, String>>>> getWithdrawalList(
            @Query("tonce") Long tonce,
            @Nullable @Query("coin_type") String coinType,
            @Nullable @Query("coin_withdraw_id") Integer coinWithdrawId,
            @Nullable @Query("page") Integer page,
            @Nullable @Query("limit") Integer limit
    );

    /**
     * Acquire Credit Account Info
     * <p></p>
     * <b>This API needs authorization</b>
     *
     * @param tonce Required | The timestamp of the request
     * @return Credit Account Info
     */
    @GET(R.BASE_V1 + "credit/info")
    CallX<ApiResponse<CreditAccount>> getCreditAccountInfo(@Query("tonce") Long tonce);
}
