package com.places.onlinetest1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.net.HttpURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.net.MalformedURLException;
import com.google.gson.*;
import android.os.StrictMode;

/**
 * Created by Shivansh on 06-02-2018.
 */

public class forecast
{
    public String MaxTemp(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/forecast.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("forecast");
        JsonArray rootarray = rootobj.getAsJsonArray("forecastday");
        rootobj = rootarray.get(0).getAsJsonObject();
        rootobj = rootobj.getAsJsonObject("day");
        String maxtmp = rootobj.get("maxtemp_c").getAsString();
        maxtmp+="°C";
        return maxtmp;
    }
    public String MinTemp(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/forecast.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("forecast");
        JsonArray rootarray = rootobj.getAsJsonArray("forecastday");
        rootobj = rootarray.get(0).getAsJsonObject();
        rootobj = rootobj.getAsJsonObject("day");
        String mintmp = rootobj.get("mintemp_c").getAsString();
        mintmp+="°C";
        return mintmp;
    }
    public String AvgTemp(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/forecast.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("forecast");
        JsonArray rootarray = rootobj.getAsJsonArray("forecastday");
        rootobj = rootarray.get(0).getAsJsonObject();
        rootobj = rootobj.getAsJsonObject("day");
        String avgtmp = rootobj.get("avgtemp_c").getAsString();
        avgtmp+="°C";
        return avgtmp;
    }
    public String MaxWindSpeed(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/forecast.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("forecast");
        JsonArray rootarray = rootobj.getAsJsonArray("forecastday");
        rootobj = rootarray.get(0).getAsJsonObject();
        rootobj = rootobj.getAsJsonObject("day");
        String maxwind = rootobj.get("maxwind_kph").getAsString();
        maxwind+=" kph";
        return maxwind;
    }
    public String AvgHumidity(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/forecast.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("forecast");
        JsonArray rootarray = rootobj.getAsJsonArray("forecastday");
        rootobj = rootarray.get(0).getAsJsonObject();
        rootobj = rootobj.getAsJsonObject("day");
        String avghumidity = rootobj.get("avghumidity").getAsString();
        avghumidity+="%";
        return avghumidity;
    }
    public String Sunrise(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/forecast.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("forecast");
        JsonArray rootarray = rootobj.getAsJsonArray("forecastday");
        rootobj = rootarray.get(0).getAsJsonObject();
        rootobj = rootobj.getAsJsonObject("astro");
        String sunrise = rootobj.get("sunrise").getAsString();
        return sunrise;
    }
    public String Sunset(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/forecast.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("forecast");
        JsonArray rootarray = rootobj.getAsJsonArray("forecastday");
        rootobj = rootarray.get(0).getAsJsonObject();
        rootobj = rootobj.getAsJsonObject("astro");
        String sunset = rootobj.get("sunset").getAsString();
        return sunset;
    }
}
