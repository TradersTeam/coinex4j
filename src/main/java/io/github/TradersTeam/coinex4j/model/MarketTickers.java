package io.github.TradersTeam.coinex4j.model;

import io.github.TradersTeam.coinex4j.model.util.PrettyJson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Map;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class MarketTickers extends PrettyJson {

    private final DateTime date;
    @SerializedName("ticker")
    private final Map<String, Ticker> tickers;
}
