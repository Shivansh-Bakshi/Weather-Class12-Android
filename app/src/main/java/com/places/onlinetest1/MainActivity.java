package com.places.onlinetest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class MainActivity extends AppCompatActivity
{
    String city;
    String placeinform;
    String currenttmp, flttemp, humidity, pressure, windspeed, cloudi, imageurl, currentdnt;
    EditText cityinput;
    TextView ctemp, fltemp, humid, press, windspe, cloud;
    TextView currentlbl, feelslbl, humiditylbl, pressurelbl, windspeedlbl, cloudinesslbl;
    TextView placeinfooutlbl, dntout, dnt;
    TextView wantforecastlbl, tommlbl;
    TextView maxtmpolbl, mintempolbl, avgtempolbl, maxwindspeolbl, avghumidolbl, suriseolbl, sunsetolbl;
    TextView maxtmplbl, mintemplbl, avgtemplbl, maxwindspelbl, avghumidlbl, sunriselbl, sunsetlbl;
    String maxtemp, mintemp, avgtemp, maxwindspeed, avghumidity, sunrisetime, sunsettime;
    Button submitbutton, yesbutton;
    ImageView currentImg;
    int responsecode;

    current cw = new current();
    placeinfo pi = new placeinfo();
    forecast fw = new forecast();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityinput=(EditText) findViewById(R.id.inputbox);
        submitbutton =(Button) findViewById(R.id.submitbtn);
        ctemp = (TextView) findViewById(R.id.ctempoutput);
        fltemp = (TextView) findViewById(R.id.flttempout);
        humid = (TextView) findViewById(R.id.humidityout);
        press = (TextView) findViewById(R.id.pressureout);
        windspe = (TextView) findViewById(R.id.windspeedout);
        cloud = (TextView) findViewById(R.id.cloudinessout);
        currentImg=(ImageView) findViewById(R.id.currentimg);
        dnt=(TextView) findViewById(R.id.currentdntlbl);
        dntout=(TextView) findViewById(R.id.dntoutlbl);

        currentlbl = (TextView) findViewById(R.id.currenttemplbl);
        feelslbl = (TextView) findViewById(R.id.feelsliketemplbl);
        humiditylbl = (TextView) findViewById(R.id.humiditylbl);
        pressurelbl = (TextView) findViewById(R.id.pressurelbl);
        windspeedlbl = (TextView) findViewById(R.id.windspeedlbl);
        cloudinesslbl = (TextView) findViewById(R.id.cloudinesslbl);
        placeinfooutlbl = (TextView) findViewById(R.id.placeinfolbl);

        wantforecastlbl = (TextView) findViewById(R.id.wanttommfor);
        yesbutton = (Button) findViewById(R.id.yesbtn);
        tommlbl = (TextView) findViewById(R.id.tommlbl);

        maxtmpolbl = (TextView) findViewById(R.id.maxtempout);
        mintempolbl = (TextView) findViewById(R.id.mintempout);
        avgtempolbl = (TextView) findViewById(R.id.avgtempout);
        maxwindspeolbl = (TextView) findViewById(R.id.maxwindspeedout);
        avghumidolbl = (TextView) findViewById(R.id.avghumidityout);
        suriseolbl = (TextView) findViewById(R.id.suriseout);
        sunsetolbl = (TextView) findViewById(R.id.sunsetout);

        maxtmplbl = (TextView) findViewById(R.id.maxtemplbl);
        mintemplbl = (TextView) findViewById(R.id.mintemplbl);
        avgtemplbl = (TextView) findViewById(R.id.avgtemplbl);
        maxwindspelbl = (TextView) findViewById(R.id.maxwindspeedlbl);
        avghumidlbl = (TextView) findViewById(R.id.avghumiditylbl);
        sunriselbl = (TextView) findViewById(R.id.sunrisetimelbl);
        sunsetlbl = (TextView) findViewById(R.id.sunsettimelbl);

        placeinfooutlbl = (TextView) findViewById(R.id.placeinfolbl);

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Error").setMessage("City not found or Bad Internet Connection. Please check the spelling or network");
        builder.setCancelable(false);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });


        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                city = cityinput.getText().toString();
                city=city.replaceAll(" ","+");

                try
                {
                    currenttmp = cw.CurrentTemp(city);
                    responsecode = cw.ResponseCode(city);
                    if(responsecode==400)
                    {
                        builder.show();
                    }
                    ctemp.setText(currenttmp);
                    currentlbl.setVisibility(View.VISIBLE);
                    ctemp.setVisibility(View.VISIBLE);

                    currentdnt = cw.DateAndTime(city);
                    dntout.setText(currentdnt);
                    dntout.setVisibility(View.VISIBLE);
                    dnt.setVisibility(View.VISIBLE);

                    imageurl=cw.CurrentImage(city);
                    loadImageFromUrl(imageurl);

                    placeinform=pi.placeinf(city);
                    placeinfooutlbl.setText(placeinform);
                    placeinfooutlbl.setVisibility(View.VISIBLE);

                    flttemp = cw.FeelsLikeTemp(city);
                    fltemp.setText(flttemp);
                    feelslbl.setVisibility(View.VISIBLE);
                    fltemp.setVisibility(View.VISIBLE);

                    humidity=cw.Humidity(city);
                    humid.setText(humidity);
                    humiditylbl.setVisibility(View.VISIBLE);
                    humid.setVisibility(View.VISIBLE);

                    pressure=cw.Pressure(city);
                    press.setText(pressure);
                    pressurelbl.setVisibility(View.VISIBLE);
                    press.setVisibility(View.VISIBLE);

                    windspeed=cw.WindSpeed(city);
                    windspe.setText(windspeed);
                    windspeedlbl.setVisibility(View.VISIBLE);
                    windspe.setVisibility(View.VISIBLE);

                    cloudi=cw.Cloud(city);
                    cloud.setText(cloudi);
                    cloudinesslbl.setVisibility(View.VISIBLE);
                    cloud.setVisibility(View.VISIBLE);

                    wantforecastlbl.setVisibility(View.VISIBLE);
                    yesbutton.setVisibility(View.VISIBLE);
                    maxtmplbl.setVisibility(View.INVISIBLE);
                    maxtmpolbl.setVisibility(View.INVISIBLE);
                    mintemplbl.setVisibility(View.INVISIBLE);
                    mintempolbl.setVisibility(View.INVISIBLE);
                    avgtemplbl.setVisibility(View.INVISIBLE);
                    avgtempolbl.setVisibility(View.INVISIBLE);
                    maxwindspelbl.setVisibility(View.INVISIBLE);
                    maxwindspeolbl.setVisibility(View.INVISIBLE);
                    avghumidlbl.setVisibility(View.INVISIBLE);
                    avghumidolbl.setVisibility(View.INVISIBLE);
                    sunriselbl.setVisibility(View.INVISIBLE);
                    suriseolbl.setVisibility(View.INVISIBLE);
                    sunsetlbl.setVisibility(View.INVISIBLE);
                    sunsetolbl.setVisibility(View.INVISIBLE);
                    tommlbl.setVisibility(View.INVISIBLE);
                }catch (IOException e)
                {
                    builder.show();
                }

                yesbutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)
                    {
                        try
                        {
                            wantforecastlbl.setVisibility(View.INVISIBLE);
                            yesbutton.setVisibility(View.INVISIBLE);
                            tommlbl.setVisibility(View.VISIBLE);

                            maxtemp=fw.MaxTemp(city);
                            maxtmpolbl.setText(maxtemp);
                            maxtmplbl.setVisibility(View.VISIBLE);
                            maxtmpolbl.setVisibility(View.VISIBLE);

                            mintemp=fw.MinTemp(city);
                            mintempolbl.setText(mintemp);
                            mintemplbl.setVisibility(View.VISIBLE);
                            mintempolbl.setVisibility(View.VISIBLE);

                            avgtemp=fw.AvgTemp(city);
                            avgtempolbl.setText(avgtemp);
                            avgtemplbl.setVisibility(View.VISIBLE);
                            avgtempolbl.setVisibility(View.VISIBLE);

                            maxwindspeed=fw.MaxWindSpeed(city);
                            maxwindspeolbl.setText(maxwindspeed);
                            maxwindspelbl.setVisibility(View.VISIBLE);
                            maxwindspeolbl.setVisibility(View.VISIBLE);

                            avghumidity=fw.AvgHumidity(city);
                            avghumidolbl.setText(avghumidity);
                            avghumidlbl.setVisibility(View.VISIBLE);
                            avghumidolbl.setVisibility(View.VISIBLE);

                            sunrisetime=fw.Sunrise(city);
                            suriseolbl.setText(sunrisetime);
                            sunriselbl.setVisibility(View.VISIBLE);
                            suriseolbl.setVisibility(View.VISIBLE);

                            sunsettime=fw.Sunset(city);
                            sunsetolbl.setText(sunsettime);
                            sunsetlbl.setVisibility(View.VISIBLE);
                            sunsetolbl.setVisibility(View.VISIBLE);

                        }catch(IOException e2)
                        {
                            System.exit(0);
                        }
                    }
                });
            }
        });
    }
    private void loadImageFromUrl(String url)
    {
        Picasso.with(this).load(url)
                .error(R.mipmap.ic_launcher_round)
                .into(currentImg, new com.squareup.picasso.Callback()
                {
                   @Override
                    public void onSuccess(){

                   }
                   @Override
                    public  void onError(){

                   }
                });
    }
}
