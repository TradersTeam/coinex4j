package com.github.TradersTeam.coinex4j.model;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class LimitConfigAdapter extends TypeAdapter<LimitConfig> {

    @Override
    public void write(JsonWriter writer, LimitConfig value) throws IOException {
        writer.beginArray();
        writer.value(value.getAmount());
        writer.value(value.getAmount());
        writer.value(value.getMaintainMargin());
        writer.endArray();
    }

    @Override
    public LimitConfig read(JsonReader reader) throws IOException {
        double amount;
        int leverage;
        double maintainMargin;

        reader.beginArray();

        amount = Double.parseDouble(reader.nextString());
        leverage = Integer.parseInt(reader.nextString());
        maintainMargin = Double.parseDouble(reader.nextString());

        reader.endArray();

        return new LimitConfig(amount, leverage, maintainMargin);
    }
}
