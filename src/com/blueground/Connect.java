package com.blueground;

import java.net.HttpURLConnection;
import java.net.URL;

public class Connect {

    public static HttpURLConnection establishConnection() throws CustomException {
        String sURL = "http://api.wunderground.com/api/012b570330c93949/history_20171030/q/NY/New_York.json";
        // Connect to the URL using java's native library
        try {
            URL url = new URL(sURL);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            return request;
        } catch (Exception e) {
            throw new CustomException("Ooops, Couldn't connect with the weather API! " +
                    "Please try again later!");
        }
    }
}
