package io.github.TradersTeam.coinex4j.model.perpetual;

import io.github.TradersTeam.coinex4j.model.util.PrettyJson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class PerpetualMarket extends PrettyJson {
    private final String name;
    private final int type;
    private final List<String> leverages;
    private final String stock;
    private final String money;
    @SerializedName("fee_prec")
    private final int feePrec;
    @SerializedName("stock_prec")
    private final int stockPrec;
    @SerializedName("money_prec")
    private final int moneyPrec;
    @SerializedName("amount_prec")
    private final int amountPrec;
    @SerializedName("amount_min")
    private final String amountMin;
    private final String multiplier;
    @SerializedName("tick_size")
    private final String tickSize;
    private final boolean available;
}
