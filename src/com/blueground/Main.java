package com.blueground;

import com.google.gson.JsonObject;
import java.net.HttpURLConnection;

public class Main {

    public static void main(String[] args) {

        HttpURLConnection request = null;
        try {
            //Establish Connection and return request
            request = Connect.establishConnection();
            System.out.println("Connection Established!");
            //Parse Json and return desired Json object
            JsonObject result = JsonReader.getWeatherData(request);
            //Export data
            System.out.println("Exporting weather data...");
            Export.printWeatherData(result);
            System.out.println("Done... results located to: NewYorkWeather.txt");
        }catch(CustomException e){
            System.out.println(e.getMessage());
        }
    }
}
