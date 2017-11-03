package com.blueground;

import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Export {
    public static void printWeatherData(JsonObject result) throws CustomException{

        //Get Results
        String maxHumP = "Max Humidity: "+ result.get("maxhumidity").getAsString()+"%";
        String maxTempC = "Max Temperature: "+ result.get("maxtempm").getAsString()+"C";
        String minTempC = "Min Temperature: "+ result.get("mintempm").getAsString()+"C";
        String precipMm = "Precipitation: "+ result.get("precipm").getAsString()+"mm";

        //Print Results to Screen
        System.out.println("\nResults: ");
        System.out.println(maxHumP);
        System.out.println(maxTempC);
        System.out.println(minTempC);
        System.out.println(precipMm);
        System.out.println();

        //Write Results to File
        String NEW_LINE_SEPARATOR = "\n";
        Path path = Paths.get("NewYorkWeather.txt");
        File file = new File(String.valueOf(path));
        if (file.exists()) {
            System.out.println("File already exists");
        } else {
            try {
                file.createNewFile();
                System.out.println("File created!");
            } catch (IOException e) {
                throw new CustomException("Something went wrong, couldn't create the file!");
            }
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.append(maxHumP);
            writer.append(NEW_LINE_SEPARATOR);
            writer.append(maxTempC);
            writer.append(NEW_LINE_SEPARATOR);
            writer.append(minTempC);
            writer.append(NEW_LINE_SEPARATOR);
            writer.append(precipMm);
            writer.append(NEW_LINE_SEPARATOR);
            writer.close();
            System.out.println("File written successfully!");
        } catch (Exception e) {
            throw new CustomException("Error while writing the file... :/");
        }
    }
}
