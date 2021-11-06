package com.github.TradersTeam.coinex4j.model.perpetual;

import com.github.TradersTeam.coinex4j.model.DateTime;
import com.github.TradersTeam.coinex4j.model.util.PrettyJson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class PerpetualMarketTicker extends PrettyJson {

    private final DateTime date;
    @SerializedName("ticker")
    private final PerpetualTicker perpetualTicker;
}
