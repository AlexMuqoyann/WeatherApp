package com.example.hp.weatherapp.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class RetroClient {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    public static ApiService getApiService() {
        return getRetrofitInstance().create(ApiService.class);
    }

    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder().
                baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
