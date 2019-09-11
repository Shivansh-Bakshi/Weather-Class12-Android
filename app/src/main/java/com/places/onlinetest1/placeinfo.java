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

public class placeinfo
{
    public String placeinf(String citynm) throws IOException
    {
        String base_LP = "http://api.geonames.org/wikipediaSearchJSON?q=";
        String style_LP="&maxRows=1&username=worpe";
        String search_LP = base_LP + citynm + style_LP;
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        URL url = new URL(search_LP);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootobj = root.getAsJsonObject();
        JsonArray rootarray = rootobj.getAsJsonArray("geonames");
        rootobj=rootarray.get(0).getAsJsonObject();
        String summary = rootobj.get("summary").getAsString();
        return summary;
    }
}
