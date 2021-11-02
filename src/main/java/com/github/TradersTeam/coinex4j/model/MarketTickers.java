package com.github.TradersTeam.coinex4j.model;

import com.github.TradersTeam.coinex4j.model.util.PrettyJson;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class MarketTickers extends PrettyJson {

    private final DateTime date;
    @SerializedName("ticker")
    private final Map<String, Ticker> tickers;

    public MarketTickers(DateTime date, Map<String, Ticker> tickers) {
        this.date = date;
        this.tickers = tickers;
    }

    public DateTime getDate() {
        return date;
    }

    public Map<String, Ticker> getTickers() {
        return tickers;
    }
}
