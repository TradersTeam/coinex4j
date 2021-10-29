package com.github.TradersTeam.coinex4j.model;

import com.github.TradersTeam.coinex4j.model.util.Stringify;

public class MarketDepthItem extends Stringify {
    private final double price;
    private final double cumulative;

    public MarketDepthItem(double price, double cumulative) {
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
