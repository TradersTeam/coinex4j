package com.github.TradersTeam.coinex4j.network;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.network.util.CallXAdapterFactory;
import com.github.TradersTeam.coinex4j.util.Constants;
import com.github.TradersTeam.coinex4j.util.Utility;
import okhttp3.OkHttpClient;
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
    public static final String AUTHORIZATION = "authorization";

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

        public static final String SHOULD_BE_CALLED_LAST_IN_METHOD_CHAIN_CALL = "Default builder should be called last in method chain call.";
        private Retrofit retrofit;
        private OkHttpClient okHttpClient;
        private String baseUrl;
        private final List<Converter.Factory> converters;
        private boolean isClientAutoShutDowned = false;
        private String accessId;
        private String secretKey;

        private boolean isDefaultBuilderCalled = false;

        public Builder() {
            converters = new ArrayList<>();
        }

        /**
         * Sets API access id.
         *
         * @param accessId API access id.
         * @return Builder
         */
        public Builder accessId(@NotNull String accessId) {
            handleIllegalBuilderMethodChain();
            this.accessId = accessId;
            return this;
        }

        /**
         * Sets API secret key.
         *
         * @param secretKey API secret key.
         * @return Builder
         */
        public Builder secretKey(@NotNull String secretKey) {
            handleIllegalBuilderMethodChain();
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
            handleIllegalBuilderMethodChain();
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
            handleIllegalBuilderMethodChain();
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
            handleIllegalBuilderMethodChain();
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
            handleIllegalBuilderMethodChain();
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
            handleIllegalBuilderMethodChain();
            this.isClientAutoShutDowned = isClientAutoShutDowned;
            return this;
        }

        /**
         * Create a default instance of CoinEx4J class,
         * by default retrofit converter factory is Gson,
         * additional converters can be added too using builder,
         * <p>
         * <b>this method should be called last in the builder chain.</b>
         *
         * @return builder class for CoinEx4J
         * @see GsonConverterFactory
         */
        public Builder createDefaultInstance() {
            if (okHttpClient == null)
                okHttpClient = new OkHttpClient.Builder().build();


            okHttpClient = okHttpClient.newBuilder().addInterceptor(chain -> {
                var originalRequest = chain.request();
                var originalUrl = originalRequest.url();
                var queryString = originalUrl.query();

                var doesApiNeedAuthorization = accessId != null && !accessId.isEmpty() && secretKey != null && !secretKey.isEmpty();

                if (doesApiNeedAuthorization) {
                    var queryParams = new HashMap<String, String>();
                    queryParams.put(ACCESS_ID, accessId);

                    if (queryString != null && !queryString.isEmpty())
                        queryParams.putAll(createMapFromQueryString(queryString));

                    List<String> keys = new ArrayList<>(queryParams.keySet());
                    //According to the documentation, the order of the keys is important and must be sorted
                    keys = keys.stream().sorted().collect(Collectors.toList());
                    //secret key should be added to the end of the sorted list
                    queryParams.put(SECRET_KEY, secretKey);
                    keys.add(SECRET_KEY);

                    String pseudoQueryString = createPseudoQueryString(queryParams, keys);

                    var md5 = Utility.MD5(pseudoQueryString);
                    if (md5 != null && !md5.isEmpty()) {
                        var newUrl = originalUrl.newBuilder()
                                .addQueryParameter(ACCESS_ID, accessId)
                                .build();
                        var newRequest = originalRequest.newBuilder()
                                .url(newUrl)
                                .addHeader(AUTHORIZATION, md5)
                                .build();
                        return chain.proceed(newRequest);
                    }
                }
                return chain.proceed(originalRequest);
            }).build();

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
            isDefaultBuilderCalled = true;
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

        /**
         * Create a map from query string
         *
         * @param queryString query string
         * @return map of query string
         */
        private HashMap<String, String> createMapFromQueryString(String queryString) {
            var queryParams = new HashMap<String, String>();
            for (String param : queryString.split("&")) {
                String[] pair = param.split("=");
                var paramName = pair[0];
                var paramValue = pair[1];
                queryParams.put(paramName, paramValue);
            }
            return queryParams;
        }

        /**
         * Create a pseudo query string from the given map
         * creates the pseudo query string used for signing and adding to the request authorization header
         *
         * @param queryParams map of query parameters
         * @param keys        list of keys in the map
         * @return pseudo query string
         */
        private String createPseudoQueryString(HashMap<String, String> queryParams, List<String> keys) {
            var stringBuilder = new StringBuilder();
            var listSize = keys.size();
            //iterate over the keys and append the key and value to the string builder
            for (int index = 0; index < listSize; index++) {
                stringBuilder.append(keys.get(index)).append("=").append(queryParams.get(keys.get(index)));
                //if the index is not the last index, append a &
                if (index != listSize - 1) stringBuilder.append("&");
            }
            return stringBuilder.toString();
        }

        private void handleIllegalBuilderMethodChain() {
            if (isDefaultBuilderCalled)
                throw new IllegalStateException(SHOULD_BE_CALLED_LAST_IN_METHOD_CHAIN_CALL);
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
