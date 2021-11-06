package com.github.TradersTeam.coinex4j.model.perpetual;

import com.github.TradersTeam.coinex4j.model.Ticker;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class PerpetualTicker extends Ticker {
    private final int period;
    @SerializedName("funding_time")
    private final int fundingTime;
    @SerializedName("position_amount")
    private final double positionAmount;
    @SerializedName("funding_rate_last")
    private final double fundingRateLast;
    @SerializedName("funding_rate_next")
    private final double fundingRateNext;
    @SerializedName("funding_rate_predict")
    private final double fundingRatePredict;
    private final String insurance;
    @SerializedName("sign_price")
    private final double signPrice;
    @SerializedName("index_price")
    private final double indexPrice;
    @SerializedName("sell_total")
    private final double sellTotal;
    @SerializedName("buy_total")
    private final double buyTotal;
}
