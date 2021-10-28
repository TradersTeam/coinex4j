package com.github.TradersTeam.coinex4j.model;

@SuppressWarnings("unused")
public class MarketTicker extends Stringify {

    private final DateTime date;
    private final Ticker ticker;

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
