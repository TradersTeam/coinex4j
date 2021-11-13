package io.github.TradersTeam.coinex4j.model;

import io.github.TradersTeam.coinex4j.model.util.PrettyJson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class MarketDepth extends PrettyJson {
    private final List<MarketDepthItem> asks;
    private final List<MarketDepthItem> bids;

    private final double last;
    @SerializedName("sign_price")
    private final double signPrice;
    @SerializedName("index_price")
    private final double indexPrice;
    private final DateTime time;
}
