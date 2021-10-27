package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface GeneralAPIs {

    @GET("perpetual/v1/ping")
    Call<ApiResponse<String>> getPing();

    @GET("perpetual/v1/time")
    Call<ApiResponse<Long>> getTime();

    @GET("v1/market/list")
    Call<ApiResponse<List<String>>> getMarketList();
}
