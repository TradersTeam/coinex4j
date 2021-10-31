package com.github.TradersTeam.coinex4j.model.perpetual;

import com.github.TradersTeam.coinex4j.util.Utility;

@SuppressWarnings("unused")
public class PerpetualLimitConfig {
    private final double amount;
    private final int leverage;
    private final double maintainMargin;

    public PerpetualLimitConfig(double amount, int leverage, double maintainMargin) {
        this.amount = amount;
        this.leverage = leverage;
        this.maintainMargin = maintainMargin;
    }

    public Double getAmount() {
        return amount;
    }

    public Integer getLeverage() {
        return leverage;
    }

    public Double getMaintainMargin() {
        return maintainMargin;
    }

    @Override
    public String toString() {
        return Utility.objectToJson(this);
    }
}
