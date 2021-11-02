package com.github.TradersTeam.coinex4j.model;

import com.github.TradersTeam.coinex4j.model.util.PrettyJson;
import com.google.gson.annotations.SerializedName;

public class MarketTicker extends PrettyJson {

    //server time when returning
    private final DateTime date;
    @SerializedName("ticker")
    private Ticker ticker;

    public MarketTicker(DateTime date, Ticker ticker) {
        this.date = date;
        this.ticker = ticker;
    }

    public DateTime getDate() {
        return date;
    }

    public Ticker getTicker() {
        return ticker;
    }
}
