package com.example.demo;

import com.google.gson.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherGetter {

    private String weatherService = "http://api.openweathermap.org/data/2.5/weather";
    private String apikey = "appid=fd7a17c24eac2e3f30e6a0a66f5d62d0";
    private String zipQuery = "?zip=02210,us";

    public boolean isRaining() throws Exception
    {

        String data = this.getData();

        JsonParser parser = new JsonParser();

        JsonObject json = (JsonObject) parser.parse(data);

        String arr = json.get("weather").toString();

        JsonArray imArr =  (JsonArray) parser.parse(arr);

        JsonObject jsonNew = (JsonObject) parser.parse(imArr.get(0).toString());

        System.out.println(jsonNew.get("main").toString().equals("Rain"));

        return jsonNew.get("main").toString().equals("Rain") || jsonNew.get("main").toString().equals("Drizzle");
    }

    private String getData() throws Exception {

        weatherService += zipQuery;

        weatherService += "&" + apikey;

        URL url = new URL(weatherService);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));

        StringBuilder toRet = new StringBuilder();

        in.lines().forEach(n -> toRet.append(n + "\n"));

        in.close();
        return toRet.toString();

    }

}
