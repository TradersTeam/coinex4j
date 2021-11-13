package io.github.TradersTeam.coinex4j.model;

import io.github.TradersTeam.coinex4j.model.util.PrettyJson;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class AssetConfig extends PrettyJson {
    private final String asset;
    private final String chain;
    @SerializedName("can_deposit")
    private final boolean canDeposit;
    @SerializedName("can_withdraw")
    private final boolean canWithdraw;
    @SerializedName("deposit_least_amount")
    private final double depositLeastAmount;
    @SerializedName("withdraw_least_amount")
    private final double withdrawLeastAmount;
    @SerializedName("withdraw_tx_fee")
    private final double withdrawTxFee;
}
