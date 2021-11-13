package io.github.TradersTeam.coinex4j.network.apis;

import io.github.TradersTeam.coinex4j.model.ApiResponse;
import io.github.TradersTeam.coinex4j.model.AssetConfig;
import io.github.TradersTeam.coinex4j.model.SiteMaintainInfo;
import io.github.TradersTeam.coinex4j.network.util.CallX;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.Map;

public interface CommonAPIs {

    String BASE = R.V1 + R.SLASH + R.COMMON + R.SLASH;
    String MAINTAIN_INFO = BASE + "maintain/info";
    String ASSET_CONFIG = BASE + "asset/config";
    String CURRENCY_RATE = BASE + "currency/rate";

    @GET(MAINTAIN_INFO)
    CallX<ApiResponse<SiteMaintainInfo>> getSiteMaintainInfo();

    /**
     * Acquire asset config
     *
     * @param coinType Optional | Coin type, e.g. BCH.
     *                 If no coin_type is entered,
     *                 the asset config of all the supported coins/tokens will be returned.
     *                 If coin_type is provided,
     *                 the asset config of the specific coin/token will be sent back instead.
     * @return map of key value of coin type and their asset config
     */
    @GET(ASSET_CONFIG)
    CallX<ApiResponse<Map<String, AssetConfig>>> getAssetConfig(
            @Nullable @Query("coin_type") String coinType
    );

    /**
     * Calls {@link #getAssetConfig(String)} with null value to get all asset configs
     *
     * @return all asset configs
     */
    default CallX<ApiResponse<Map<String, AssetConfig>>> getAssetConfigs() {
        return getAssetConfig(null);
    }

    /**
     * Acquire currency rate
     *
     * @return map of currency rates
     */
    @GET(CURRENCY_RATE)
    CallX<ApiResponse<Map<String, Double>>> getCurrencyRates();
}
