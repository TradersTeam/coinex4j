package io.github.TradersTeam.coinex4j.model.market;

import io.github.TradersTeam.coinex4j.model.DateTime;
import io.github.TradersTeam.coinex4j.model.util.PrettyJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class KLineData extends PrettyJson {
    private final DateTime time;
    private final double openingPrice;
    private final double closingPrice;
    private final double highestPrice;
    private final double lowestPrice;
    private final double volume;
    private final double amount;
}
