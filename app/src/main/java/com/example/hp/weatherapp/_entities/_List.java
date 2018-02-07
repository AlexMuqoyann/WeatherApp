package com.example.hp.weatherapp._entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HP on 06.02.2018.
 */

public class _List {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("dt")
    @Expose
    private int dt;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coord")
    @Expose
    private _Coord coord;
    @SerializedName("main")
    @Expose
    private _Main main;
    @SerializedName("wind")
    @Expose
    private _Wind wind;
    @SerializedName("rain")
    @Expose
    private Object rain;
    @SerializedName("snow")
    @Expose
    private Object snow;
    @SerializedName("clouds")
    @Expose
    private _Clouds clouds;
    @SerializedName("weather")
    @Expose
    private java.util.List<_Weather> weather = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public _Coord getCoord() {
        return coord;
    }

    public void setCoord(_Coord coord) {
        this.coord = coord;
    }

    public _Main getMain() {
        return main;
    }

    public void setMain(_Main main) {
        this.main = main;
    }

    public _Wind getWind() {
        return wind;
    }

    public void setWind(_Wind wind) {
        this.wind = wind;
    }

    public Object getRain() {
        return rain;
    }

    public void setRain(Object rain) {
        this.rain = rain;
    }

    public Object getSnow() {
        return snow;
    }

    public void setSnow(Object snow) {
        this.snow = snow;
    }

    public _Clouds getClouds() {
        return clouds;
    }

    public void setClouds(_Clouds clouds) {
        this.clouds = clouds;
    }

    public List<_Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<_Weather> weather) {
        this.weather = weather;
    }

}
