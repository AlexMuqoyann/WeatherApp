package com.example.hp.weatherapp._entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by HP on 06.02.2018.
 */

public class _Example {

    @SerializedName("cod")
    @Expose
    private int cod;
    @SerializedName("calctime")
    @Expose
    private double calctime;
    @SerializedName("cnt")
    @Expose
    private int cnt;
    @SerializedName("list")
    @Expose
    private List<_List> list = null;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getCalctime() {
        return calctime;
    }

    public void setCalctime(double calctime) {
        this.calctime = calctime;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<_List> getList() {
        return list;
    }

    public void setList(List<_List> list) {
        this.list = list;
    }

}
