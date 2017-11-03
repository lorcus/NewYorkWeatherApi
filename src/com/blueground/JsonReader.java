package com.blueground;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class JsonReader {

    public static JsonObject getWeatherData(HttpURLConnection request) throws CustomException {
        // Convert to a JSON object to print data
        JsonParser jp = new JsonParser();
        //Convert the input stream to a json element
        JsonElement root = null;
        try {
            root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            JsonObject rootobj = root.getAsJsonObject();
            JsonObject res = rootobj.get("history").getAsJsonObject()
                    .get("dailysummary").getAsJsonArray().get(0).getAsJsonObject();
            return res;
        } catch (Exception e) {
            throw new CustomException("Ooops, Couldn't parse Json Object");
        }
    }
}
