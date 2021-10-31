package com.github.TradersTeam.coinex4j.model.perpetual;

import com.github.TradersTeam.coinex4j.model.util.Stringify;

public class PerpetualMarketDepthItem extends Stringify {
    private final double price;
    private final double cumulative;

    public PerpetualMarketDepthItem(double price, double cumulative) {
        this.price = price;
        this.cumulative = cumulative;
    }

    public double getPrice() {
        return price;
    }

    public double getCumulative() {
        return cumulative;
    }
}
