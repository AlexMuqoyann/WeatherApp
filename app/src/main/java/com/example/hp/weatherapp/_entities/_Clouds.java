package com.example.hp.weatherapp._entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 06.02.2018.
 */

public class _Clouds {

    @SerializedName("today")
    @Expose
    private int today;

    public int getToday() {
        return today;
    }

    public void setToday(int today) {
        this.today = today;
    }

}
