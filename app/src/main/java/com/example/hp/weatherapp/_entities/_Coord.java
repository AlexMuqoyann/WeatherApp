package com.example.hp.weatherapp._entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 06.02.2018.
 */

public class _Coord {


        @SerializedName("Lat")
        @Expose
        private double lat;
        @SerializedName("Lon")
        @Expose
        private double lon;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }


}
