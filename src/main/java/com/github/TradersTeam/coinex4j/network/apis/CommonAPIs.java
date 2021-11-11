package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.model.SiteMaintainInfo;
import com.github.TradersTeam.coinex4j.network.util.CallX;
import retrofit2.http.GET;

public interface CommonAPIs {

    String MAINTAIN_INFO = R.V1 + R.SLASH + R.COMMON + R.SLASH + "maintain/info";

    @GET(MAINTAIN_INFO)
    CallX<ApiResponse<SiteMaintainInfo>> getSiteMaintainInfo();

}
