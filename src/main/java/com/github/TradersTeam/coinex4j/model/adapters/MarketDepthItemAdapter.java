package com.github.TradersTeam.coinex4j.model.adapters;

import com.github.TradersTeam.coinex4j.model.MarketDepthItem;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class MarketDepthItemAdapter extends TypeAdapter<MarketDepthItem> {

    @Override
    public void write(JsonWriter writer, MarketDepthItem value) throws IOException {
        writer.beginArray();
        writer.value(value.getPrice());
        writer.value(value.getAmount());
        writer.endArray();
    }

    @Override
    public MarketDepthItem read(JsonReader reader) throws IOException {
        double price;
        double amount;

        reader.beginArray();
        price = reader.nextDouble();
        amount = reader.nextDouble();
        reader.endArray();

        return new MarketDepthItem(price, amount);
    }
}
