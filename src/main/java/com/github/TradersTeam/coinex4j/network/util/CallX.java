package com.github.TradersTeam.coinex4j.network.util;

import com.github.TradersTeam.coinex4j.network.CoinEx4J;
import retrofit2.Call;
import retrofit2.Response;

import java.util.function.BiConsumer;

public interface CallX<T> extends Call<T> {

    void asyncCall(CoinEx4J coinEx4J, BiConsumer<Call<T>, Response<T>> success, BiConsumer<Call<T>, Throwable> fail);

    void async(CoinEx4J coinEx4J, BiConsumer<Response<T>, Throwable> callback);

    void asyncBody(CoinEx4J coinEx4J, BiConsumer<T, Throwable> callback);
}