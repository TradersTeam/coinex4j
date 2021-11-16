package io.github.TradersTeam.coinex4j.model.market;

public enum MarketTransactionType {
    BUY("buy"), SELL("sell");

    private final String value;

    MarketTransactionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
