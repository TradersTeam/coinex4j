package io.github.TradersTeam.coinex4j.model.market;

import io.github.TradersTeam.coinex4j.model.DateTime;
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
public class MarketTicker extends PrettyJson {

    //server time when returning
    private final DateTime date;
    @SerializedName("ticker")
    private final Ticker ticker;
}
