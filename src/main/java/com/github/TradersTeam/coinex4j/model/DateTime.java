package com.github.TradersTeam.coinex4j.model;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
public class DateTime extends Stringify {

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
