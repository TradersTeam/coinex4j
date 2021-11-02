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
public final class MarketTransaction extends PrettyJson {
    private final long id;
    private final MarketTransactionType type;
    private final double price;
    private final double amount;
    @SerializedName("date")
    private final DateTime dateOfSeconds;
    @SerializedName("date_ms")
    private final DateTime dateOfMilliseconds;
}
