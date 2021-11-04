package com.github.TradersTeam.coinex4j.model;

import com.github.TradersTeam.coinex4j.model.util.PrettyJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class AccountAsset extends PrettyJson {
    private final String available;
    private final String frozen;
}
