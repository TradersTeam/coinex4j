package com.github.TradersTeam.coinex4j.model;

import com.github.TradersTeam.coinex4j.model.util.Stringify;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MarketDepth extends Stringify {

    private final List<MarketDepthItem> asks;
    private final List<MarketDepthItem> bids;

    private final double last;
    @SerializedName("sign_price")
    private final double signPrice;
    @SerializedName("index_price")
    private final double indexPrice;

    public MarketDepth(List<MarketDepthItem> asks, List<MarketDepthItem> bids, double last, double signPrice, double indexPrice) {
        this.asks = asks;
        this.bids = bids;
        this.last = last;
        this.signPrice = signPrice;
        this.indexPrice = indexPrice;
    }

    public List<MarketDepthItem> getAsks() {
        return asks;
    }

    public List<MarketDepthItem> getBids() {
        return bids;
    }

    public double getLast() {
        return last;
    }

    public double getSignPrice() {
        return signPrice;
    }

    public double getIndexPrice() {
        return indexPrice;
    }
}
