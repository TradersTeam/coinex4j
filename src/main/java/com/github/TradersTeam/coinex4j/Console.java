package com.github.TradersTeam.coinex4j;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.network.Web;
import com.github.TradersTeam.coinex4j.network.apis.GeneralAPIs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.util.List;

public class Console {
    public static void main(String... args) {

        //System.out.println(run("https://api.coinex.com/v1/market/list"));


        Retrofit client = Web.getClient();
        Call<ApiResponse<List<String>>> call = client.create(GeneralAPIs.class).getMarketList();

        call.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<ApiResponse<List<String>>> call, Response<ApiResponse<List<String>>> response) {
                System.out.println(response.body().getData().get(0));
            }

            @Override
            public void onFailure(Call<ApiResponse<List<String>>> call, Throwable t) {
                System.out.println("error");
            }
        });

//        Web.async(call, (response, error) -> {
//            if (response != null && error == null)
//                System.out.println(response.getData());
//            else System.out.println(error.getMessage());
//        });

    }


//    static String run(String url) throws IOException {
//        OkHttpClient client = new OkHttpClient();
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//
//        try (Response response = client.newCall(request).execute()) {
//            return response.body().string();
//        }
//    }

}
