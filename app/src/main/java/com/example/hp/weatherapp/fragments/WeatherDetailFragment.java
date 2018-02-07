package com.example.hp.weatherapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hp.weatherapp.R;
import com.example.hp.weatherapp._entities._Example;
import com.example.hp.weatherapp._entities._List;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherDetailFragment extends Fragment {

    private TextView tv_temp;
    private TextView tv_feels_like;
    private TextView tv_hight;
    private TextView tv_min;
    private _List _list;

    public WeatherDetailFragment() {

    }

    public static WeatherDetailFragment newInstance(_List list) {
        WeatherDetailFragment weatherDetailFragment = new WeatherDetailFragment();
        weatherDetailFragment._list = list;
        return weatherDetailFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_weather_detail, container, false);
        tv_temp = v.findViewById(R.id.tv_temp);
        tv_feels_like = v.findViewById(R.id.tv_feels_like);
        tv_hight = v.findViewById(R.id.tv_hight);
        tv_min = v.findViewById(R.id.tv_min);
        tv_temp.setText(String.valueOf(_list.getMain().getTemp()));
        tv_hight.setText(String.valueOf(_list.getMain().getTempMax()));
        tv_min.setText(String.valueOf(_list.getMain().getTempMin()));
        tv_feels_like.setText(String.valueOf(_list.getMain().getHumidity()));
        return v;
    }

}
