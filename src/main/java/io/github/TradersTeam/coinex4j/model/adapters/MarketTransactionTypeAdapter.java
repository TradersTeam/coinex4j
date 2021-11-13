package io.github.TradersTeam.coinex4j.model.adapters;

import io.github.TradersTeam.coinex4j.model.MarketTransactionType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class MarketTransactionTypeAdapter extends TypeAdapter<MarketTransactionType> {
    @Override
    public void write(JsonWriter out, MarketTransactionType value) throws IOException {
        if (value == MarketTransactionType.BUY) out.value("buy");
        if (value == MarketTransactionType.SELL) out.value("sell");
    }

    @Override
    public MarketTransactionType read(JsonReader in) throws IOException {
        MarketTransactionType typeOutput;
        var typeInput = in.nextString();
        if (typeInput.equals("buy")) typeOutput = MarketTransactionType.BUY;
        else if (typeInput.equals("sell")) typeOutput = MarketTransactionType.SELL;
        else typeOutput = null;
        return typeOutput;
    }
}
