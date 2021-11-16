package io.github.TradersTeam.coinex4j.network.apis;

import com.google.gson.JsonObject;
import io.github.TradersTeam.coinex4j.model.ApiResponse;
import io.github.TradersTeam.coinex4j.network.util.CallX;
import org.jetbrains.annotations.ApiStatus;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;
import java.util.Map;

public interface MarginAPIs {

    String BASE = R.V1 + R.SLASH + R.MARGIN + R.SLASH;

    /**
     * Inquire margin market ID map info.
     *
     * @return map of market names and their ids
     */
    @GET(BASE + "market")
    CallX<ApiResponse<Map<String, String>>> getMarginAccountMarketInfo();

    /**
     * Inquire margin account asset structure.
     *
     * @return margin account asset structure
     */
    @ApiStatus.Experimental
    @GET(BASE + "account")
    CallX<ApiResponse<JsonObject>> getMarginAccountInfo(
            @Query("tonce") Long tonce,
            @Query("market") String market
    );

    @ApiStatus.Experimental
    @GET(BASE + "config")
    CallX<ApiResponse<List<JsonObject>>> getMarginAccountSettings(@Query("tonce") Long tonce);
}
