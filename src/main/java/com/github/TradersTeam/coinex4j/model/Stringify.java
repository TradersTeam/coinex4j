package com.github.TradersTeam.coinex4j.model;

import com.github.TradersTeam.coinex4j.util.Utility;

abstract class Stringify {

    @Override
    public String toString() {
        return Utility.objectToJson(this);
    }
}
