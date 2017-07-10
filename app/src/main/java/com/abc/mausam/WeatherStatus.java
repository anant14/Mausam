package com.abc.mausam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.abc.mausam.API.WeatherAPI;
import com.abc.mausam.Adapters.WeatherRecyclerAdapter;
import com.abc.mausam.Models.Result;
import com.abc.mausam.Models.consolidated_weather;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherStatus extends AppCompatActivity{

    public static final String TAG = "WeatherStatus";
    RecyclerView rvlist;
    WeatherRecyclerAdapter weatherRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_status);

        rvlist = (RecyclerView)findViewById(R.id.rvlist);
        rvlist.setLayoutManager(new LinearLayoutManager(this));
        weatherRecyclerAdapter = new WeatherRecyclerAdapter(WeatherStatus.this,new ArrayList<consolidated_weather>());



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.metaweather.com/api/")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);

        weatherAPI.getWeatherBywoeid(getIntent().getIntExtra("woeid",-1)).enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.d(TAG, "onResponse: "+response.body().getConsolidated_weather());
                /*weatherRecyclerAdapter.updateWeather(response.body().getConsolidated_weather());
                rvlist.setAdapter(weatherRecyclerAdapter);*/
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t);
            }
        });

    }
}
