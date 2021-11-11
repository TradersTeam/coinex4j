package com.github.TradersTeam.coinex4j.network.apis;

import com.github.TradersTeam.coinex4j.model.ApiResponse;
import com.github.TradersTeam.coinex4j.model.AssetConfig;
import com.github.TradersTeam.coinex4j.model.SiteMaintainInfo;
import com.github.TradersTeam.coinex4j.network.util.CallX;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

public interface CommonAPIs {

    String BASE = R.V1 + R.SLASH + R.COMMON + R.SLASH;
    String MAINTAIN_INFO = BASE + "maintain/info";
    String ASSET_CONFIG = BASE + "asset/config";

    @GET(MAINTAIN_INFO)
    CallX<ApiResponse<SiteMaintainInfo>> getSiteMaintainInfo();

    @GET(ASSET_CONFIG)
    CallX<ApiResponse<Map<String, AssetConfig>>> getAssetConfig(
            @Nullable @Query("coin_type") String coinType
    );

    default CallX<ApiResponse<Map<String, AssetConfig>>> getAssetConfigs() {
        return getAssetConfig(null);
    }
}
