package io.github.TradersTeam.coinex4j.model.margin;

import com.google.gson.annotations.SerializedName;
import io.github.TradersTeam.coinex4j.model.util.PrettyJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class MarginAccount extends PrettyJson {
    @SerializedName("account_id")
    private final int accountId;
    private final int leverage;
    @SerializedName("market_type")
    private final String marketType;
    @SerializedName("sell_asset_type")
    private final String sellAssetType;
    @SerializedName("buy_asset_type")
    private final String buyAssetType;
    private final MarginAmount balance;
    private final MarginAmount frozen;
    private final MarginAmount loan;
    private final MarginAmount interest;
    @SerializedName("can_transfer")
    private final MarginAmount canTransfer;
    @SerializedName("warn_rate")
    /*
     * because of the poor design of coinex api,
     * the warn_rate is a string here, not a double whereas it's actually a number,
     * but if user doesn't have a balance api will return nothing instead of 0.0,
     * same problem exist for liquidation_price
     */
    private final String warnRate;
    @SerializedName("liquidation_price")
    private final String liquidationPrice;
}
