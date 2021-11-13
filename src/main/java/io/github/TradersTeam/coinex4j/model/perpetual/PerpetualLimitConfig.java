package io.github.TradersTeam.coinex4j.model.perpetual;

import io.github.TradersTeam.coinex4j.model.util.PrettyJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class PerpetualLimitConfig extends PrettyJson {
    private final double amount;
    private final int leverage;
    private final double maintainMargin;
}
