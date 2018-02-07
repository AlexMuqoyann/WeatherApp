package com.example.hp.weatherapp.activitys;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.weatherapp.R;
import com.example.hp.weatherapp._entities._Example;
import com.example.hp.weatherapp._entities._List;
import com.example.hp.weatherapp.adapters.CountryAdapter;
import com.example.hp.weatherapp.entitites.MainWeatherData;
import com.example.hp.weatherapp.fragments.WeatherDetailFragment;
import com.example.hp.weatherapp.http.ApiService;
import com.example.hp.weatherapp.http.RetroClient;
import com.example.hp.weatherapp.interfaces.RecyclerViewOnClickListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener, RecyclerViewOnClickListener {


    private RecyclerView rv;
    private CountryAdapter adapter;
    private Toolbar toolbar;
    private List<_List> lists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Search");
        setSupportActionBar(toolbar);
        rv = findViewById(R.id.rv);
        Log.d("Alex", "Hello");
        ApiService apiService1 = RetroClient.getApiService();
        Call<_Example> call = apiService1.getWeathersOfCountries();
        call.enqueue(new Callback<_Example>() {
            @Override
            public void onResponse(Call<_Example> call, Response<_Example> response) {
                Log.d("Alex", response.body().toString());
                setAdapter(response.body().getList());
            }

            @Override
            public void onFailure(Call<_Example> call, Throwable t) {
                Log.d("Alex", t.toString());
            }
        });


    }

    private void setAdapter(List<_List> data) {
        adapter = new CountryAdapter(MainActivity.this, data, this);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        lists = data;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_xml, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    private void searchByCountry(String countryName) {
        ApiService apiService = RetroClient.getApiService();

        Call<MainWeatherData> call1 = apiService.getCurrentWeather(countryName);

        call1.enqueue(new Callback<MainWeatherData>() {
            @Override
            public void onResponse(Call<MainWeatherData> call, Response<MainWeatherData> response) {
                MainWeatherData mainWeatherData = response.body();
                final AlertDialog.Builder customDialog = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater;
                inflater = LayoutInflater.from(MainActivity.this);
                final View view = inflater.inflate(R.layout.custom_dialog, null);
                TextView cd_tv_country = view.findViewById(R.id.cd_tv_country);
                TextView cd_tv_temp_min = view.findViewById(R.id.cd_tv_temp_min);
                TextView cd_temp_max = view.findViewById(R.id.cd_temp_max);
                TextView cd_tv_sunrise = view.findViewById(R.id.cd_tv_sunrise);
                TextView cd_tv_sunset = view.findViewById(R.id.cd_tv_sunset);
                cd_tv_country.setText(mainWeatherData.getSys().getCountry());
                cd_tv_temp_min.setText(String.valueOf(mainWeatherData.getMain().getTempMin()));
                cd_temp_max.setText(String.valueOf(mainWeatherData.getMain().getTempMax()));
                cd_tv_sunrise.setText(String.valueOf(mainWeatherData.getSys().getSunrise()));
                cd_tv_sunset.setText(String.valueOf(mainWeatherData.getSys().getSunset()));
                customDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                customDialog.setView(view);
                AlertDialog dialog = customDialog.create();
                dialog.show();


            }

            @Override
            public void onFailure(Call<MainWeatherData> call, Throwable t) {

            }
        });


    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        searchByCountry(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        return true;
    }

    @Override
    public void onItemClick(View v, int position) {
        switch (v.getId()) {
            case R.id.tv_temp:
                WeatherDetailFragment weatherDetailFragment = WeatherDetailFragment.newInstance(lists.get(position));
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.main_container, weatherDetailFragment).addToBackStack(null).commit();
        }
    }
}
