package io.github.TradersTeam.coinex4j.model.market;

import io.github.TradersTeam.coinex4j.model.util.PrettyJson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
@NoArgsConstructor
public class Ticker extends PrettyJson {
    //24H volume
    protected double vol;
    //24H the lowest price
    protected double low;
    //24H open price
    protected double open;
    //24H the highest price
    protected double high;
    //latest price
    protected double last;
    //buy 1
    protected double buy;
    //buy 1 amount
    @SerializedName("buy_amount")
    protected double buyAmount;
    //sell 1
    protected double sell;
    //sell 1 amount
    @SerializedName("sell_amount")
    protected double sellAmount;
}
