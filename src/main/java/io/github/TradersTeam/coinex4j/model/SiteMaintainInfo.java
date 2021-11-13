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
public class SiteMaintainInfo extends PrettyJson {
    @SerializedName("start_time")
    private final DateTime startTime;
    @SerializedName("end_time")
    private final DateTime endTime;
    private final String url;
}
