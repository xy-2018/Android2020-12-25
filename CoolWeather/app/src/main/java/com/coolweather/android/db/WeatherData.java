package com.coolweather.android.db;

public class WeatherData {

    private static String cityName ;
//            = weather.basic.cityName;
    private static String updateTime;
//            = weather.basic.update.updateTime.split(" ")[1]; //按24小时计时的时间
    private static String degree;
//            = weather.now.temperature + "°C";
    private static String weatherInfo;
//            = weather.now.more.info;


    public  String getCityName() {
        return cityName;
    }

    public  void setCityName(String cityName) {
        WeatherData.cityName = cityName;
    }

    public  String getUpdateTime() {
        return updateTime;
    }

    public  void setUpdateTime(String updateTime) {
        WeatherData.updateTime = updateTime;
    }

    public  String getDegree() {
        return degree;
    }

    public  void setDegree(String degree) {
        WeatherData.degree = degree;
    }

    public  String getWeatherInfo() {
        return weatherInfo;
    }

    public  void setWeatherInfo(String weatherInfo) {
        WeatherData.weatherInfo = weatherInfo;
    }
}
