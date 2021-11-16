package io.github.TradersTeam.coinex4j.model.account;

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
public class CreditAccount extends PrettyJson {
    @SerializedName("withdraw_rate")
    private final double withdrawRate;
    @SerializedName("trade_rate")
    private final double tradeRate;
    @SerializedName("current_balance")
    private final double currentBalance;
    @SerializedName("unflat_balance")
    private final double unflatBalance;
    @SerializedName("can_withdraw_balance")
    private final double canWithdrawBalance;
    @SerializedName("can_trade_balance")
    private final double canTradeBalance;
    @SerializedName("current_rate")
    private final double currentRate;
}
