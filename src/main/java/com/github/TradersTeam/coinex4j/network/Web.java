package com.github.TradersTeam.coinex4j.network;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.util.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Web {

    private static Retrofit client = null;

    public static Retrofit getClient() {
        if (client == null) {
            client = new Retrofit.Builder()
                    .baseUrl(Constants.baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return client;
    }

    public static <T> void async(Call<ApiResponse<T>> call, BiConsumer<ApiResponse<T>, Throwable> callback) {
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ApiResponse<T>> call, Response<ApiResponse<T>> response) {
                callback.accept(response.body(), null);
            }

            @Override
            public void onFailure(Call<ApiResponse<T>> call, Throwable t) {
                callback.accept(null, t);
            }
        });
    }

    public static <T> void asyncCall(Call<ApiResponse<T>> call, Consumer<ApiResponse<T>> onResponse, Consumer<Throwable> onError) {
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ApiResponse<T>> call, Response<ApiResponse<T>> response) {
                onResponse.accept(response.body());
            }

            @Override
            public void onFailure(Call<ApiResponse<T>> call, Throwable t) {
                onError.accept(t);
            }
        });
    }

}
