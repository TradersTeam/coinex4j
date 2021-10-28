package com.github.TradersTeam.coinex4j.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Ticker extends Stringify {
    private final long vol;
    private final double low;
    private final double open;
    private final double high;
    private final double last;
    private final double buy;
    private final int period;
    @SerializedName("funding_time")
    private final int fundingTime;
    @SerializedName("position_amount")
    private final long positionAmount;
    @SerializedName("funding_rate_last")
    private final double fundingRateLast;
    @SerializedName("funding_rate_next")
    private final double fundingRateNext;
    @SerializedName("funding_rate_predict")
    private final double fundingRatePredict;
    private final String insurance;
    @SerializedName("sign_price")
    private final double signPrice;
    @SerializedName("index_price")
    private final double indexPrice;
    @SerializedName("sell_total")
    private final double sellTotal;
    @SerializedName("buy_total")
    private final double buyTotal;
    @SerializedName("buy_amount")
    private final double buyAmount;
    private final double sell;
    @SerializedName("sell_amount")
    private final double sellAmount;

    public Ticker(long vol, double low, double open, double high, double last, double buy, int period, int fundingTime, long positionAmount, double fundingRateLast, double fundingRateNext, double fundingRatePredict, String insurance, double signPrice, double indexPrice, double sellTotal, double buyTotal, double buyAmount, double sell, double sellAmount) {
        this.vol = vol;
        this.low = low;
        this.open = open;
        this.high = high;
        this.last = last;
        this.buy = buy;
        this.period = period;
        this.fundingTime = fundingTime;
        this.positionAmount = positionAmount;
        this.fundingRateLast = fundingRateLast;
        this.fundingRateNext = fundingRateNext;
        this.fundingRatePredict = fundingRatePredict;
        this.insurance = insurance;
        this.signPrice = signPrice;
        this.indexPrice = indexPrice;
        this.sellTotal = sellTotal;
        this.buyTotal = buyTotal;
        this.buyAmount = buyAmount;
        this.sell = sell;
        this.sellAmount = sellAmount;
    }

    public long getVol() {
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

    public int getPeriod() {
        return period;
    }

    public int getFundingTime() {
        return fundingTime;
    }

    public long getPositionAmount() {
        return positionAmount;
    }

    public double getFundingRateLast() {
        return fundingRateLast;
    }

    public double getFundingRateNext() {
        return fundingRateNext;
    }

    public double getFundingRatePredict() {
        return fundingRatePredict;
    }

    public String getInsurance() {
        return insurance;
    }

    public double getSignPrice() {
        return signPrice;
    }

    public double getIndexPrice() {
        return indexPrice;
    }

    public double getSellTotal() {
        return sellTotal;
    }

    public double getBuyTotal() {
        return buyTotal;
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
