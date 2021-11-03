package com.github.TradersTeam.coinex4j.model.adapters;

import com.github.TradersTeam.coinex4j.model.DateTime;
import com.github.TradersTeam.coinex4j.model.KLineData;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class KLineDataAdapter extends TypeAdapter<KLineData> {
    @Override
    public void write(JsonWriter out, KLineData value) throws IOException {
        out.beginArray();
        out.value(value.time().timestamp());
        out.value(value.openingPrice());
        out.value(value.closingPrice());
        out.value(value.highestPrice());
        out.value(value.lowestPrice());
        out.value(value.volume());
        out.value(value.amount());
        out.endArray();
    }

    @Override
    public KLineData read(JsonReader in) throws IOException {
        DateTime time;
        double open;
        double close;
        double high;
        double low;
        double vol;
        double amount;

        in.beginArray();
        var timestamp = in.nextLong();
        var localDateTime = LocalDateTime.ofEpochSecond(timestamp, 0, ZoneOffset.UTC);
        time = new DateTime(timestamp, localDateTime);
        open = in.nextDouble();
        close = in.nextDouble();
        high = in.nextDouble();
        low = in.nextDouble();
        vol = in.nextDouble();
        amount = in.nextDouble();
        in.endArray();

        return new KLineData(time, open, close, high, low, vol, amount);
    }
}
