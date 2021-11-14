package io.github.TradersTeam.coinex4j.model;

import com.google.gson.annotations.SerializedName;
import io.github.TradersTeam.coinex4j.model.util.PrettyJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class MarginAmount extends PrettyJson {
    @SerializedName("sell_type")
    private final double sellType;
    @SerializedName("buy_type")
    private final double buyType;
}
