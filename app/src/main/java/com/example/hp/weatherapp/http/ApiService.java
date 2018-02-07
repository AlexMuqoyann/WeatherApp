package com.example.hp.weatherapp.http;


import com.example.hp.weatherapp._entities._Example;
import com.example.hp.weatherapp.entitites.MainWeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface ApiService {
    @Headers("Content-Type: application/json")
    @GET("weather?&APPID=fc15df372bbba47612d74758cd1f5a0a")
    Call<MainWeatherData> getCurrentWeather(@Query("q") String address);


    @Headers("Content-Type: application/json")
    @GET("box/city?bbox=12%2C32%2C37%2C10&appid=fc15df372bbba47612d74758cd1f5a0a")
    Call<_Example> getWeathersOfCountries();

}
