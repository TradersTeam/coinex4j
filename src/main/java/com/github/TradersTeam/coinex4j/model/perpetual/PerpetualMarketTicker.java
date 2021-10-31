package com.github.TradersTeam.coinex4j.model.perpetual;

import com.github.TradersTeam.coinex4j.model.DateTime;
import com.github.TradersTeam.coinex4j.model.util.Stringify;

@SuppressWarnings("unused")
public class PerpetualMarketTicker extends Stringify {

    private final DateTime date;
    private final PerpetualTicker perpetualTicker;

    public PerpetualMarketTicker(DateTime date, PerpetualTicker perpetualTicker) {
        this.date = date;
        this.perpetualTicker = perpetualTicker;
    }

    public DateTime getDate() {
        return date;
    }

    public PerpetualTicker getTicker() {
        return perpetualTicker;
    }
}
