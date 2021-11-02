package com.github.TradersTeam.coinex4j.model;

import com.github.TradersTeam.coinex4j.model.util.PrettyJson;

import java.time.LocalDateTime;

public class DateTime extends PrettyJson {

    private final long timestamp;
    private final LocalDateTime localDateTime;

    public DateTime(long timestamp, LocalDateTime localDateTime) {
        this.timestamp = timestamp;
        this.localDateTime = localDateTime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
