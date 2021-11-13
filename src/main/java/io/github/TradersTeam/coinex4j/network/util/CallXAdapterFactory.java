package io.github.TradersTeam.coinex4j.network.util;

import io.github.TradersTeam.coinex4j.network.CoinEx4J;
import okhttp3.Request;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;
import retrofit2.*;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.function.BiConsumer;

public final class CallXAdapterFactory extends CallAdapter.Factory {

    @Override
    public CallAdapter<?, ?> get(Type type, Annotation[] annotations, Retrofit retrofit) {
        //this line will allow retrofit to use default call adapter for types other than CallX
        if (getRawType(type) != CallX.class) return null;

        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("Call must have generic type (e.g., Call<ResponseBody>)");
        }

        final Type responseType = getParameterUpperBound(0, (ParameterizedType) type);
        return new CallXAdapter<>(responseType);
    }

    private static final class CallXAdapter<R> implements CallAdapter<R, CallX<R>> {
        private final Type responseType;

        CallXAdapter(Type responseType) {
            this.responseType = responseType;
        }

        @Override
        public @NotNull Type responseType() {
            return responseType;
        }

        @Override
        public @NotNull CallX<R> adapt(@NotNull Call<R> call) {
            return new MyCallXAdapter<>(call);
        }
    }

    static class MyCallXAdapter<T> implements CallX<T> {
        private final Call<T> call;

        MyCallXAdapter(Call<T> call) {
            this.call = call;
        }

        @Override
        public Response<T> execute() throws IOException {
            return call.execute();
        }

        @Override
        public void enqueue(Callback<T> callback) {
            call.enqueue(callback);
        }

        @Override
        public boolean isExecuted() {
            return call.isExecuted();
        }

        @Override
        public void cancel() {
            call.cancel();
        }

        @Override
        public boolean isCanceled() {
            return call.isCanceled();
        }

        @Override
        public Call<T> clone() {
            return new MyCallXAdapter<>(call.clone());
        }

        @Override
        public Request request() {
            return call.request();
        }

        @Override
        public Timeout timeout() {
            return call.timeout();
        }

        @Override
        public void asyncCall(CoinEx4J coinEx4J, BiConsumer<Call<T>, Response<T>> success, BiConsumer<Call<T>, Throwable> fail) {
            Objects.requireNonNull(coinEx4J, "CoinEx4J == null");
            Objects.requireNonNull(success, "success lambda == null");
            Objects.requireNonNull(fail, "fail lambda == null");

            call.enqueue(new Callback<>() {
                @Override
                public void onResponse(Call<T> call, Response<T> response) {
                    if (call.isCanceled()) fail.accept(call, new IOException("Canceled"));
                    else success.accept(call, response);
                    shutdownIfNeeded(coinEx4J);
                }

                @Override
                public void onFailure(Call<T> call, Throwable t) {
                    fail.accept(call, t);
                    shutdownIfNeeded(coinEx4J);
                }
            });
        }

        @Override
        public void async(CoinEx4J coinEx4J, BiConsumer<Response<T>, Throwable> callback) {
            call.enqueue(new Callback<>() {
                @Override
                public void onResponse(Call<T> call, Response<T> response) {
                    callback.accept(response, null);
                    shutdownIfNeeded(coinEx4J);
                }

                @Override
                public void onFailure(Call<T> call, Throwable t) {
                    callback.accept(null, t);
                    shutdownIfNeeded(coinEx4J);
                }
            });
        }

        @Override
        public void asyncBody(CoinEx4J coinEx4J, BiConsumer<T, Throwable> callback) {
            call.enqueue(new Callback<>() {
                @Override
                public void onResponse(Call<T> call, Response<T> response) {
                    var body = response.body();
                    if (body == null) callback.accept(null, new IOException("Response body is null!"));
                    else callback.accept(body, null);
                    shutdownIfNeeded(coinEx4J);
                }

                @Override
                public void onFailure(Call<T> call, Throwable t) {
                    callback.accept(null, t);
                    shutdownIfNeeded(coinEx4J);
                }
            });
        }

        /**
         * Check if API client is set to be auto shut downed
         */
        private void shutdownIfNeeded(CoinEx4J coinEx4J) {
            if (coinEx4J.isClientAutoShutDowned()) shutdown(coinEx4J);
        }

        /**
         * By default, OkHttp uses non-daemon thread,
         * this will prevent the JVM from exiting until they time out.
         * so this method is used for shutting down threads manually.
         */
        private void shutdown(CoinEx4J coinEx4J) {
            var okHttpClient = coinEx4J.getOkHttpClient();
            okHttpClient.dispatcher().executorService().shutdown();
            okHttpClient.connectionPool().evictAll();
        }
    }
}