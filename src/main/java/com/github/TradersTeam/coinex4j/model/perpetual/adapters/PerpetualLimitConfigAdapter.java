package com.github.TradersTeam.coinex4j.model.perpetual.adapters;

import com.github.TradersTeam.coinex4j.model.perpetual.PerpetualLimitConfig;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class PerpetualLimitConfigAdapter extends TypeAdapter<PerpetualLimitConfig> {

    @Override
    public void write(JsonWriter writer, PerpetualLimitConfig value) throws IOException {
        writer.beginArray();
        writer.value(value.amount());
        writer.value(value.leverage());
        writer.value(value.maintainMargin());
        writer.endArray();
    }

    @Override
    public PerpetualLimitConfig read(JsonReader reader) throws IOException {
        double amount;
        int leverage;
        double maintainMargin;

        reader.beginArray();

        amount = Double.parseDouble(reader.nextString());
        leverage = Integer.parseInt(reader.nextString());
        maintainMargin = Double.parseDouble(reader.nextString());

        reader.endArray();

        return new PerpetualLimitConfig(amount, leverage, maintainMargin);
    }
}
