package com.github.TradersTeam.coinex4j.model;

public enum MarketTransactionType {
    BUY("sell"), SELL("sell");

    private final String value;

    MarketTransactionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
