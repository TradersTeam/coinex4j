package com.github.TradersTeam.coinex4j.model;

import com.github.TradersTeam.coinex4j.model.util.PrettyJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.ApiStatus;

import java.time.LocalDateTime;
import java.time.ZoneOffset;


/**
 * DateTime with nanoseconds precision, however response from json is in milliseconds precision
 */
@Accessors(fluent = true)
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data()
public class DateTime extends PrettyJson {

    private final long timestamp;
    private final LocalDateTime localDateTime;

    /**
     * if epoch time precision is in seconds,
     * use this method for getting true date time,
     * beware that calling this method on an epoch with nanoseconds or milliseconds precision,
     * returns unexpected result
     *
     * @return LocalDateTime
     */
    @ApiStatus.Experimental
    public LocalDateTime getLocalDateTimeOfSeconds() {
        return LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.UTC);
    }
}
