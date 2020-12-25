package com.coolweather.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.coolweather.android.db.WeatherData;

public class Choose_LocationActivity extends AppCompatActivity {


    private TextView cityNameindex = null;
    private TextView updateTimeindex = null;
    private TextView degreeindex = null;
    private TextView weatherInfoindex = null;
    static String tianqi = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__location);

        Button auto_loaction_btn=findViewById(R.id.auto_location_btn);
        Button hand_loaction_btn=findViewById(R.id.hand_location_btn);
        Button to_news_btn=findViewById(R.id.to_news_btn);
        Button to_xingzuo_btn=findViewById(R.id.to_xingzuo_btn);

        cityNameindex = findViewById(R.id.cityName);
        updateTimeindex = findViewById(R.id.updateTime);
        degreeindex = findViewById(R.id.degree);
        weatherInfoindex = findViewById(R.id.weatherInfo);

        //手动天气
        hand_loaction_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_mainactivity_intent =new Intent(Choose_LocationActivity.this,MainActivity.class);
                startActivity(to_mainactivity_intent);
            }
        });

        //定位
        auto_loaction_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent to_mapactivity_intent = new Intent(Choose_LocationActivity.this,MapActivity.class);
                startActivity(to_mapactivity_intent);
            }
        });
    //新闻
        to_news_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_news_intent = new Intent(Choose_LocationActivity.this,News_MainActivity.class);
                startActivity(to_news_intent);
            }
        });
        //星座
        to_xingzuo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent to_xingzuo_intent = new Intent(Choose_LocationActivity.this,XingzuoActivity.class);
                startActivity(to_xingzuo_intent);
            }
        });

    }
    @Override
    protected void onResume() {
        super.onResume();
        WeatherData weatherData = new WeatherData();

        cityNameindex.setText(weatherData.getCityName());
        updateTimeindex.setText(weatherData.getUpdateTime());
        degreeindex.setText(weatherData.getDegree());
        weatherInfoindex.setText(weatherData.getWeatherInfo());
        NotificationManager manager =(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification =new NotificationCompat.Builder(this)
                .setContentTitle("当前城市:"+weatherData.getCityName())
                .setContentText("当前气温"+weatherData.getDegree()+"--"+weatherData.getWeatherInfo())
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.logo)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.logo))
                .build();
        manager.notify(1,notification);
    }
}
