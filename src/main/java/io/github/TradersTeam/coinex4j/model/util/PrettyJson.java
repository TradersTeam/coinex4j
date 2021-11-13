package io.github.TradersTeam.coinex4j.model.util;

import io.github.TradersTeam.coinex4j.util.Utility;

public abstract class PrettyJson {

    @Override
    public String toString() {
        return Utility.objectToJson(this);
    }
}
