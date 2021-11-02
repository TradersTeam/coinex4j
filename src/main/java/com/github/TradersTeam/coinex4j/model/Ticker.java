package com.github.TradersTeam.coinex4j.model;

import com.github.TradersTeam.coinex4j.model.util.PrettyJson;
import com.google.gson.annotations.SerializedName;

public class Ticker extends PrettyJson {
    protected final double vol;
    protected final double low;
    protected final double open;
    protected final double high;
    protected final double last;
    protected final double buy;
    @SerializedName("buy_amount")
    protected final double buyAmount;
    protected final double sell;
    @SerializedName("sell_amount")
    protected final double sellAmount;

    public Ticker(double vol, double low, double open, double high, double last, double buy, double buyAmount, double sell, double sellAmount) {
        this.vol = vol;
        this.low = low;
        this.open = open;
        this.high = high;
        this.last = last;
        this.buy = buy;
        this.buyAmount = buyAmount;
        this.sell = sell;
        this.sellAmount = sellAmount;
    }

    public double getVol() {
        return vol;
    }

    public double getLow() {
        return low;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLast() {
        return last;
    }

    public double getBuy() {
        return buy;
    }

    public double getBuyAmount() {
        return buyAmount;
    }

    public double getSell() {
        return sell;
    }

    public double getSellAmount() {
        return sellAmount;
    }
}
