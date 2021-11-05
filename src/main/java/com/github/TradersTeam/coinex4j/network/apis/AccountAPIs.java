package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.AccountAsset;
import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.network.util.CallX;
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
}
