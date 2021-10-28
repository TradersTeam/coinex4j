package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.model.DateTime;
import retrofit2.Call;
import retrofit2.http.GET;

public interface SystemAPIs {
    @GET("perpetual/v1/ping")
    Call<ApiResponse<String>> getPing();

    @GET("perpetual/v1/time")
    Call<ApiResponse<DateTime>> getTime();
}
