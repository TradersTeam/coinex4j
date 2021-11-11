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
public class MarketTransaction extends PrettyJson {
    //Transaction No
    private final long id;
    //buy/sell
    private final MarketTransactionType type;
    //Transaction price
    private final double price;
    //Transaction amount
    private final double amount;
    //Transaction time
    @SerializedName("date")
    private final DateTime dateOfSeconds;
    //Transaction time(ms)
    @SerializedName("date_ms")
    private final DateTime dateOfMilliseconds;
}
