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

public class current
{
    public int ResponseCode(String city) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/current.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+city;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        int code=request.getResponseCode();
        return code;
    }

    public String CurrentTemp(String city) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/current.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+city;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("current");
        String currenttmp = rootobj.get("temp_c").getAsString();
        currenttmp+="°C";
        return currenttmp;
    }
    public String FeelsLikeTemp(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/current.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("current");
        String fltTemp = rootobj.get("feelslike_c").getAsString();
        fltTemp+="°C";
        return fltTemp;
    }
    public String Humidity(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/current.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("current");
        String humid = rootobj.get("humidity").getAsString();
        humid+="%";
        return humid;
    }
    public String Pressure(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/current.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("current");
        String press = rootobj.get("pressure_mb").getAsString();
        press+=" mb";
        return press;
    }
    public String WindSpeed(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/current.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("current");
        String windkph = rootobj.get("wind_kph").getAsString();
        windkph+=" kph";
        return windkph;
    }
    public String Cloud(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/current.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("current");
        rootobj=rootobj.getAsJsonObject("condition");
        String cloudiness = rootobj.get("text").getAsString();
        return cloudiness;
    }
    public String CurrentImage(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/current.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("current");
        rootobj=rootobj.getAsJsonObject("condition");
        String imgurl = "http:";
        imgurl += rootobj.get("icon").getAsString();
        return imgurl;
    }
    public String DateAndTime(String citynm) throws IOException
    {
        String base_URL="http://api.apixu.com/v1/current.json?key=b1832133bf1e4366966121854181801&q=";
        String search_URL=base_URL+citynm;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_URL);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        rootobj=rootobj.getAsJsonObject("location");
        String dnt = rootobj.get("localtime").getAsString();
        return dnt;
    }
}
