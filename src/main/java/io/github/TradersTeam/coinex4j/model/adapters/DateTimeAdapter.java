package io.github.TradersTeam.coinex4j.model.adapters;

import io.github.TradersTeam.coinex4j.model.DateTime;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateTimeAdapter extends TypeAdapter<DateTime> {

    @Override
    public void write(JsonWriter writer, DateTime value) throws IOException {
        long writeData;
        if (value != null) writeData = value.timestamp();
        else writeData = 0;
        writer.value(writeData);
    }

    @Override
    public DateTime read(JsonReader reader) throws IOException {
        long timestamp = reader.nextLong();
        long seconds = timestamp / 1000;
        int nanos = (int) (timestamp % 1000);
        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(seconds, nanos, ZoneOffset.UTC);
        return new DateTime(timestamp, localDateTime);
    }
}
