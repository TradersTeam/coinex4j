package com.github.TradersTeam.coinex4j.model.perpetual.adapters;

import com.github.TradersTeam.coinex4j.model.perpetual.PerpetualMarketDepthItem;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class PerpetualMarketDepthItemAdapter extends TypeAdapter<PerpetualMarketDepthItem> {

    @Override
    public void write(JsonWriter writer, PerpetualMarketDepthItem value) throws IOException {
        writer.beginArray();
        writer.value(value.getPrice());
        writer.value(value.getCumulative());
        writer.endArray();
    }

    @Override
    public PerpetualMarketDepthItem read(JsonReader reader) throws IOException {
        double price;
        double cumulative;

        reader.beginArray();
        price = reader.nextDouble();
        cumulative = reader.nextDouble();
        reader.endArray();

        return new PerpetualMarketDepthItem(price, cumulative);
    }
}
