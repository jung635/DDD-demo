package com.example.demo.user.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GsonUtil {
    private static String PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    private static String PATTERN_DATETIME = String.format(PATTERN);

    static class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {
        DateTimeFormatter format = DateTimeFormatter.ofPattern(PATTERN_DATETIME);

        @Override
        public void write(JsonWriter out, LocalDateTime value) throws IOException {
            if(value != null)
                out.value(value.format(format));
        }

        @Override
        public LocalDateTime read(JsonReader in) throws IOException {
            return LocalDateTime.parse(in.nextString(), format);
        }
    }

    public static final Gson gson = new GsonBuilder()
            .setLenient()
            .setDateFormat(PATTERN)
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter().nullSafe())
            .create();
}
