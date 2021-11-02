package com.github.TradersTeam.coinex4j.model;

import com.github.TradersTeam.coinex4j.model.util.PrettyJson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class Ticker extends PrettyJson {
    //24H volume
    protected final double vol;
    //24H the lowest price
    protected final double low;
    //24H open price
    protected final double open;
    //24H the highest price
    protected final double high;
    //latest price
    protected final double last;
    //buy 1
    protected final double buy;
    //buy 1 amount
    @SerializedName("buy_amount")
    protected final double buyAmount;
    //sell 1
    protected final double sell;
    //sell 1 amount
    @SerializedName("sell_amount")
    protected final double sellAmount;
}
