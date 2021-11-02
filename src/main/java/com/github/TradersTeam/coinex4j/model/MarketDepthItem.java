package com.github.TradersTeam.coinex4j.model;

import com.github.TradersTeam.coinex4j.model.util.PrettyJson;

public class MarketDepthItem extends PrettyJson {
    private final double price;
    private final double amount;

    public MarketDepthItem(double price, double amount) {
        this.price = price;
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }
}
