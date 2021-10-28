package com.github.TradersTeam.coinex4j.network;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Helper class for fetching API Calls Asynchronously
 *
 * @param <T> type of API response data, which can be anything like {@code String, Long or List}
 */
public class AsyncResponse<T> {

    Call<ApiResponse<T>> call;
    CoinEx4J coinEx4J;

    public AsyncResponse(Call<ApiResponse<T>> call, CoinEx4J coinEx4J) {
        this.call = call;
        this.coinEx4J = coinEx4J;
    }

    /**
     * Wrapper method that uses Java lambda for making callback code looking more clean
     *
     * @param callback callback lambda with two arguments {@code ApiResponse<T>}, {@code Throwable}
     * @see BiConsumer
     */
    public void async(BiConsumer<ApiResponse<T>, Throwable> callback) {
        if (call.isExecuted()) alreadyExecuted();
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ApiResponse<T>> call, Response<ApiResponse<T>> response) {
                callback.accept(response.body(), null);
                shutdownIfNeeded();
            }

            @Override
            public void onFailure(Call<ApiResponse<T>> call, Throwable t) {
                callback.accept(null, t);
                shutdownIfNeeded();
            }
        });
    }

    /**
     * Wrapper method that uses Java lambda for making callback code looking more clean,
     * this method use two different {@code Consumer} instead of {@code BiConsumer}
     *
     * @param onResponse on response successful callback
     * @param onError    on error received callback
     * @see Consumer
     */
    public void asyncBi(Consumer<ApiResponse<T>> onResponse, Consumer<Throwable> onError) {
        if (call.isExecuted()) alreadyExecuted();
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ApiResponse<T>> call, Response<ApiResponse<T>> response) {
                onResponse.accept(response.body());
                shutdownIfNeeded();
            }

            @Override
            public void onFailure(Call<ApiResponse<T>> call, Throwable t) {
                onError.accept(t);
                shutdownIfNeeded();
            }
        });
    }

    /**
     * Wrapper method that uses Java lambda for making callback code looking more clean,
     *
     * @param onResponse on response successful callback with {@code retrofit.Response} argument
     * @param onError    on error received callback
     */
    public void asyncCall(BiConsumer<Call<ApiResponse<T>>, Response<ApiResponse<T>>> onResponse, Consumer<Throwable> onError) {
        if (call.isExecuted()) alreadyExecuted();
        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ApiResponse<T>> call, Response<ApiResponse<T>> response) {
                onResponse.accept(call, response);
                shutdownIfNeeded();
            }

            @Override
            public void onFailure(Call<ApiResponse<T>> call, Throwable t) {
                onError.accept(t);
                shutdownIfNeeded();
            }
        });
    }

    /**
     * Check if API client is set to be auto shut downed
     */
    private void shutdownIfNeeded() {
        if (coinEx4J.isClientAutoShutDowned()) shutdown();
    }

    /**
     * By default, OkHttp uses non-daemon thread,
     * this will prevent the JVM from exiting until they time out.
     * so this method is used for shutting down threads manually.
     */
    private void shutdown() {
        var okHttpClient = coinEx4J.getOkHttpClient();
        okHttpClient.dispatcher().executorService().shutdown();
        okHttpClient.connectionPool().evictAll();
    }

    private void alreadyExecuted() {
        throw new IllegalStateException("Already Executed");
    }
}
