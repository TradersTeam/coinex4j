package com.github.TradersTeam.coinex4j.network;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class AsyncResponse<T> {

    Call<ApiResponse<T>> call;
    CoinEx4J coinEx4J;

    public AsyncResponse(Call<ApiResponse<T>> call, CoinEx4J coinEx4J) {
        this.call = call;
        this.coinEx4J = coinEx4J;
    }


    public void async(BiConsumer<ApiResponse<T>, Throwable> callback) {
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ApiResponse<T>> call, Response<ApiResponse<T>> response) {
                callback.accept(response.body(), null);
                shutdown();
            }

            @Override
            public void onFailure(Call<ApiResponse<T>> call, Throwable t) {
                callback.accept(null, t);
                shutdown();
            }
        });
    }

    public void asyncBi(Consumer<ApiResponse<T>> onResponse, Consumer<Throwable> onError) {
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

    public void asyncCall(BiConsumer<Call<ApiResponse<T>>, Response<ApiResponse<T>>> onResponse, Consumer<Throwable> onError) {
        if (call.isExecuted()) throw new IllegalStateException("Already Executed");
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ApiResponse<T>> call, Response<ApiResponse<T>> response) {
                onResponse.accept(call, response);
            }

            @Override
            public void onFailure(Call<ApiResponse<T>> call, Throwable t) {
                onError.accept(t);
            }
        });
    }

    private void shutdown() {
        if (coinEx4J.isClientAutoShutDowned()) {
            var okHttpClient = coinEx4J.getOkHttpClient();
            okHttpClient.dispatcher().executorService().shutdown();
            okHttpClient.connectionPool().evictAll();
        }
    }
}
