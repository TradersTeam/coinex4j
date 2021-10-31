package com.github.TradersTeam.coinex4j.model.perpetual;

import com.github.TradersTeam.coinex4j.model.util.Stringify;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class PerpetualMarket extends Stringify {
    private final String name;
    private final int type;
    private final List<String> leverages;
    private final String stock;
    private final String money;
    @SerializedName("fee_prec")
    private final int feePrec;
    @SerializedName("stock_prec")
    private final int stockPrec;
    @SerializedName("money_prec")
    private final int moneyPrec;
    @SerializedName("amount_prec")
    private final int amountPrec;
    @SerializedName("amount_min")
    private final String amountMin;
    private final String multiplier;
    @SerializedName("tick_size")
    private final String tickSize;
    private final boolean available;

    public PerpetualMarket(String name, int type, List<String> leverages, String stock, String money, int feePrec, int stockPrec, int moneyPrec, int amountPrec, String amountMin, String multiplier, String tickSize, boolean available) {
        this.name = name;
        this.type = type;
        this.leverages = leverages;
        this.stock = stock;
        this.money = money;
        this.feePrec = feePrec;
        this.stockPrec = stockPrec;
        this.moneyPrec = moneyPrec;
        this.amountPrec = amountPrec;
        this.amountMin = amountMin;
        this.multiplier = multiplier;
        this.tickSize = tickSize;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public List<String> getLeverages() {
        return leverages;
    }

    public String getStock() {
        return stock;
    }

    public String getMoney() {
        return money;
    }

    public int getFeePrec() {
        return feePrec;
    }

    public int getStockPrec() {
        return stockPrec;
    }

    public int getMoneyPrec() {
        return moneyPrec;
    }

    public int getAmountPrec() {
        return amountPrec;
    }

    public String getAmountMin() {
        return amountMin;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public String getTickSize() {
        return tickSize;
    }

    public boolean isAvailable() {
        return available;
    }
}
