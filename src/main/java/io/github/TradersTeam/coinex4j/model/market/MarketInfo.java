package io.github.TradersTeam.coinex4j.model.market;

import io.github.TradersTeam.coinex4j.model.util.PrettyJson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class MarketInfo extends PrettyJson {
    private final String name;
    @SerializedName("taker_fee_rate")
    private final double takerFeeRate;
    @SerializedName("maker_fee_rate")
    private final double makerFeeRate;
    @SerializedName("min_amount")
    private final double minAmount;
    @SerializedName("trading_name")
    private final String tradingName;
    @SerializedName("trading_decimal")
    private final int tradingDecimal;
    @SerializedName("pricing_decimal")
    private final int pricingDecimal;
    @SerializedName("pricing_name")
    private final String pricingName;
}
