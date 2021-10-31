package com.github.TradersTeam.coinex4j.model.perpetual;

import com.github.TradersTeam.coinex4j.model.DateTime;
import com.github.TradersTeam.coinex4j.model.util.Stringify;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class PerpetualMarketTickers extends Stringify {

    private final DateTime date;
    @SerializedName("ticker")
    private final Map<String, PerpetualTicker> tickers;

    public PerpetualMarketTickers(DateTime date, Map<String, PerpetualTicker> tickers) {
        this.date = date;
        this.tickers = tickers;
    }

    public DateTime getDate() {
        return date;
    }

    public Map<String, PerpetualTicker> getTickers() {
        return tickers;
    }
}
