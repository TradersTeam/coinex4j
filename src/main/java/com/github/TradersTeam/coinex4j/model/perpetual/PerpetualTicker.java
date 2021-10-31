package com.github.TradersTeam.coinex4j.model.perpetual;

import com.github.TradersTeam.coinex4j.model.Ticker;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class PerpetualTicker extends Ticker {
    private final int period;
    @SerializedName("funding_time")
    private final int fundingTime;
    @SerializedName("position_amount")
    private final double positionAmount;
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

    public PerpetualTicker(double vol, double low, double open, double high, double last, double buy, double buyAmount, double sell, double sellAmount, int period, int fundingTime, double positionAmount, double fundingRateLast, double fundingRateNext, double fundingRatePredict, String insurance, double signPrice, double indexPrice, double sellTotal, double buyTotal) {
        super(vol, low, open, high, last, buy, buyAmount, sell, sellAmount);
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
    }
}
