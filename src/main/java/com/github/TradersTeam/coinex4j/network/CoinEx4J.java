package com.github.TradersTeam.coinex4j.network;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.network.util.CallXAdapterFactory;
import com.github.TradersTeam.coinex4j.util.Constants;
import com.github.TradersTeam.coinex4j.util.Utility;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CoinEx4J client class
 */
public class CoinEx4J {

    public static final String SECRET_KEY = "secret_key";
    public static final String ACCESS_ID = "access_id";
    private final Retrofit retrofit;
    private final OkHttpClient okHttpClient;
    private final String baseUrl;
    private final List<Converter.Factory> converters;
    private final boolean isClientAutoShutDowned;
    private final String accessId;
    private final String secretKey;

    CoinEx4J(@NotNull Builder builder) {
        this.retrofit = builder.retrofit;
        this.okHttpClient = builder.okHttpClient;
        this.baseUrl = builder.baseUrl;
        this.converters = builder.converters;
        this.isClientAutoShutDowned = builder.isClientAutoShutDowned;
        this.accessId = builder.accessId;
        this.secretKey = builder.secretKey;
    }

    public String getAccessId() {
        return accessId;
    }

    public String getSecretKey() {
        return secretKey;
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

    public List<Converter.Factory> getConverters() {
        return converters;
    }

    public boolean isClientAutoShutDowned() {
        return isClientAutoShutDowned;
    }

    /**
     * Builder class for CoinEx4J client class
     */
    public static final class Builder {

        private Retrofit retrofit;
        private OkHttpClient okHttpClient;
        private String baseUrl;
        private final List<Converter.Factory> converters;
        private boolean isClientAutoShutDowned = false;
        private String accessId;
        private String secretKey;

        public Builder() {
            converters = new ArrayList<>();
        }

        public Builder accessId(String accessId) {
            this.accessId = accessId;
            return this;
        }

        public Builder secretKey(String secretKey) {
            this.secretKey = secretKey;
            return this;
        }

        /**
         * Sets retrofit client for class.
         *
         * @param retrofit retrofit instance
         * @return Builder
         */
        public Builder retrofit(@NotNull Retrofit retrofit) {
            this.retrofit = retrofit;
            return this;
        }

        /**
         * Sets OkHttp client for class.
         *
         * @param okHttpClient OkHttp client instance
         * @return Builder
         */
        public Builder okhttp(@NotNull OkHttpClient okHttpClient) {
            this.okHttpClient = okHttpClient;
            return this;
        }

        /**
         * Sets API base URL.
         *
         * @param baseUrl API base URL.
         * @return Builder
         */
        public Builder baseUrl(@NotNull String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        /**
         * Adds new converter factory for serialization and deserialization of objects.
         *
         * @param converter converter factory instance
         * @return Builder
         */
        public Builder addConverter(@NotNull Converter.Factory converter) {
            converters.add(converter);
            return this;
        }

        /**
         * Sets status of whether client is shut down automatically or not
         *
         * @param isClientAutoShutDowned true|false
         * @return Builder
         */
        public Builder autoShutDown(boolean isClientAutoShutDowned) {
            this.isClientAutoShutDowned = isClientAutoShutDowned;
            return this;
        }

        /**
         * Create a default instance of CoinEx4J class,
         * by default retrofit converter factory is Gson,
         * additional converters can be added too using builder
         *
         * @return builder class for CoinEx4J
         * @see GsonConverterFactory
         */
        public Builder createDefaultInstance() {
            if (okHttpClient == null)
                okHttpClient = new OkHttpClient.Builder().build();

            okHttpClient.newBuilder().addInterceptor(chain -> {
                Request originalRequest = chain.request();
                var originalUrl = originalRequest.url();

                var queryString = originalUrl.query();
                var accessIdQuery = originalUrl.queryParameter(ACCESS_ID);

                if (queryString != null && !queryString.isEmpty() && accessIdQuery != null && !accessIdQuery.isEmpty() && accessId != null && !accessId.isEmpty() && secretKey != null && !secretKey.isEmpty()) {
                    var queryParams = new HashMap<>();
                    queryParams.put(ACCESS_ID, accessId);
                    queryParams.put(SECRET_KEY, secretKey);

                    for (String param : queryString.split("&")) {
                        String[] pair = param.split("=");
                        var paramName = pair[0];
                        var paramValue = pair[1];
                        queryParams.put(paramName, paramValue);
                    }

                    List<String> keys = new ArrayList<>();
                    for (Object key : queryParams.keySet())
                        keys.add((String) key);

                    var stringBuilder = new StringBuilder();
                    keys = keys.stream().sorted().collect(Collectors.toList());
                    for (String key : keys)
                        stringBuilder.append(key).append("=").append(queryParams.get(key)).append("&");

                    var md5 = Utility.MD5(stringBuilder.toString());
                    if (md5 != null && !md5.isEmpty()) {
                        var newRequest = originalRequest.newBuilder()
                                .addHeader(SECRET_KEY, md5)
                                .build();
                        return chain.proceed(newRequest);
                    }
                }
                return chain.proceed(originalRequest);
            });

            converters.add(GsonConverterFactory.create(Utility.getGson()));

            if (retrofit == null) {
                Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                        .baseUrl(Constants.baseUrl)
                        .client(okHttpClient)
                        .addCallAdapterFactory(new CallXAdapterFactory());
                for (Converter.Factory converter : converters) {
                    retrofitBuilder.addConverterFactory(converter);
                }
                retrofit = retrofitBuilder.build();
            }
            return this;
        }

        /**
         * Build configured CoinEx4J client class
         *
         * @return instance of CoinEx4J client class based on configuration
         */
        public CoinEx4J build() {
            return new CoinEx4J(this);
        }
    }

    /**
     * Get response in blocking way
     *
     * @return Response
     * @throws IOException if a problem occurred talking to the server
     */
    public <T> Response<ApiResponse<T>> get(@NotNull Call<ApiResponse<T>> call) throws IOException {
        if (call.isExecuted()) throw new IllegalStateException("Already Executed");
        return call.execute();
    }

    /**
     * Wrapper method for creating retrofit service
     *
     * @param service class of service
     * @param <T>     type of service class
     * @return service interface
     */
    public <T> T createAPI(final Class<T> service) {
        return retrofit.create(service);
    }
}
