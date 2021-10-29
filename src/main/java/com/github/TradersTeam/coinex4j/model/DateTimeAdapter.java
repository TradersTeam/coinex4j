package com.github.TradersTeam.coinex4j.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateTimeAdapter extends TypeAdapter<DateTime> {

    @Override
    public void write(JsonWriter writer, DateTime value) throws IOException {
        writer.value(value.getTimestamp());
    }

    @Override
    public DateTime read(JsonReader reader) throws IOException {
        long timestamp = reader.nextLong();
        long millis = timestamp / 1000;
        int nanos = (int) (timestamp % 1000);
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(millis, nanos, ZoneOffset.UTC);
        return new DateTime(timestamp, localDateTime);
    }
}
