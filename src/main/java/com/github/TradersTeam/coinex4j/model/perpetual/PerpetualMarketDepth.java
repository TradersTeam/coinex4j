package com.github.TradersTeam.coinex4j.model.perpetual;

import com.github.TradersTeam.coinex4j.model.util.Stringify;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PerpetualMarketDepth extends Stringify {

    private final List<PerpetualMarketDepthItem> asks;
    private final List<PerpetualMarketDepthItem> bids;

    private final double last;
    @SerializedName("sign_price")
    private final double signPrice;
    @SerializedName("index_price")
    private final double indexPrice;

    public PerpetualMarketDepth(List<PerpetualMarketDepthItem> asks, List<PerpetualMarketDepthItem> bids, double last, double signPrice, double indexPrice) {
        this.asks = asks;
        this.bids = bids;
        this.last = last;
        this.signPrice = signPrice;
        this.indexPrice = indexPrice;
    }

    public List<PerpetualMarketDepthItem> getAsks() {
        return asks;
    }

    public List<PerpetualMarketDepthItem> getBids() {
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
