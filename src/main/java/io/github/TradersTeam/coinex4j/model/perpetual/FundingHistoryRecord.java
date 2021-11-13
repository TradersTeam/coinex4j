package io.github.TradersTeam.coinex4j.model.perpetual;

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
public class FundingHistoryRecord extends PrettyJson {
    /**
     * sample time from server in this api is 1636243209.649114,
     * I don't know why, but it's not the same as the timestamp in the response of other APIs,
     * Whether it's in milliseconds or seconds, it's unknown or maybe numbers after decimal point is precision
     */
    private final double time;
    private final String market;
    private final String asset;
    @SerializedName("funding_rate")
    private final double fundingRate;
    @SerializedName("funding_rate_real")
    private final double fundingRealRate;
}
