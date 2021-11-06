package com.github.TradersTeam.coinex4j.network.util;

import com.github.TradersTeam.coinex4j.network.CoinEx4J;
import retrofit2.Call;
import retrofit2.Response;

import java.util.function.BiConsumer;

public interface CallX<T> extends Call<T> {

    /**
     * Executes the request asynchronously.
     *
     * @param coinEx4J coinEx4J client
     * @param success  success callback with call and response as parameters
     * @param fail     failure callback with call and throwable as parameters
     */
    void asyncCall(CoinEx4J coinEx4J, BiConsumer<Call<T>, Response<T>> success, BiConsumer<Call<T>, Throwable> fail);

    /**
     * Executes the request asynchronously.
     *
     * @param coinEx4J coinEx4J client
     * @param callback callback with response and throwable as parameters
     */
    void async(CoinEx4J coinEx4J, BiConsumer<Response<T>, Throwable> callback);

    /**
     * Executes the request asynchronously.
     *
     * @param coinEx4J coinEx4J client
     * @param callback callback with response body and throwable as parameters
     */
    void asyncBody(CoinEx4J coinEx4J, BiConsumer<T, Throwable> callback);
}