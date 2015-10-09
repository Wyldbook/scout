package com.wyldbook.scout.utils.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

public class Serializer {

    public static <T> T fromJson(String jsonString, Class<T> type) {
        try {
            return (new ObjectMapper()).readValue(jsonString, type);
        } catch (IOException e) {
            return null;
        }
    }

    public static String toJson(Object objectToSerialize) {
        StringWriter stringWriter = new StringWriter();
        try {
            new ObjectMapper().writeValue(stringWriter, objectToSerialize);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringWriter.toString();
    }

}
