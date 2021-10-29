package com.github.TradersTeam.coinex4j.model.util;

import com.github.TradersTeam.coinex4j.util.Utility;

public abstract class Stringify {

    @Override
    public String toString() {
        return Utility.objectToJson(this);
    }
}
