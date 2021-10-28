package com.github.TradersTeam.coinex4j.network;

import com.github.TradersTeam.coinex4j.util.Constants;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinEx4J {

    private final Retrofit retrofit;
    private final OkHttpClient okHttpClient;
    private final String baseUrl;
    private final Converter.Factory converter;
    private final boolean isClientAutoShutDowned;

    CoinEx4J(Builder builder) {
        this.retrofit = builder.retrofit;
        this.okHttpClient = builder.okHttpClient;
        this.baseUrl = builder.baseUrl;
        this.converter = builder.converter;
        this.isClientAutoShutDowned = builder.isClientAutoShutDowned;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public Converter.Factory getConverter() {
        return converter;
    }

    public boolean isClientAutoShutDowned() {
        return isClientAutoShutDowned;
    }

    public static final class Builder {

        private Retrofit retrofit;
        private OkHttpClient okHttpClient;
        private String baseUrl;
        private Converter.Factory converter;
        private boolean isClientAutoShutDowned = false;

        public Builder() {
        }

        public Builder retrofit(Retrofit retrofit) {
            this.retrofit = retrofit;
            return this;
        }

        public Builder okhttp(OkHttpClient okHttpClient) {
            this.okHttpClient = okHttpClient;
            return this;
        }

        public Builder baseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder converter(Converter.Factory converter) {
            this.converter = converter;
            return this;
        }

        public Builder autoShutDown(boolean isClientAutoShutDowned) {
            this.isClientAutoShutDowned = isClientAutoShutDowned;
            return this;
        }

        /**
         * Create a default instance of CoinEx4J class,
         * by default retrofit converter factory is Gson
         *
         * @return builder class for CoinEx4J
         * @see GsonConverterFactory
         */
        public Builder createDefaultInstance() {
            if (okHttpClient == null)
                okHttpClient = new OkHttpClient.Builder().build();

            if (converter == null)
                converter = GsonConverterFactory.create();

            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(Constants.baseUrl)
                        .client(okHttpClient)
                        .addConverterFactory(converter)
                        .build();
            }
            return this;
        }

        public CoinEx4J build() {
            return new CoinEx4J(this);
        }
    }

    public <T> T createAPI(final Class<T> service) {
        return retrofit.create(service);
    }
}
