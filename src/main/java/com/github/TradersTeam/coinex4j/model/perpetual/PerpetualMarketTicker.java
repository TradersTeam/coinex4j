package com.github.TradersTeam.coinex4j.model.perpetual;

import com.github.TradersTeam.coinex4j.model.DateTime;
import com.github.TradersTeam.coinex4j.model.util.PrettyJson;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PerpetualMarketTicker extends PrettyJson {

    private final DateTime date;
    @SerializedName("ticker")
    private final PerpetualTicker perpetualTicker;

    public PerpetualMarketTicker(DateTime date, PerpetualTicker perpetualTicker) {
        this.date = date;
        this.perpetualTicker = perpetualTicker;
    }

    public PerpetualTicker getPerpetualTicker() {
        return perpetualTicker;
    }

    public DateTime getDate() {
        return date;
    }
}
