package com.abc.mausam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.abc.mausam.API.WeatherAPI;
import com.abc.mausam.Adapters.WeatherRecyclerAdapter;
import com.abc.mausam.Models.Weather;

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
        weatherRecyclerAdapter = new WeatherRecyclerAdapter(this , new ArrayList<Weather>());
        rvlist.setAdapter(weatherRecyclerAdapter);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.metaweather.com/api/")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);
        Callback<ArrayList<Weather>> WeatherCallBack = new Callback<ArrayList<Weather>>() {

            @Override
            public void onResponse(Call<ArrayList<Weather>> call, Response<ArrayList<Weather>> response) {
                weatherRecyclerAdapter.updateWeather(response.body());
                Log.d(TAG, "Response Recieved" + response);
            }

            @Override
            public void onFailure(Call<ArrayList<Weather>> call, Throwable t) {
                Log.d(TAG, "Response not recieved");

            }
        };

        int woeidRecieved = getIntent().getIntExtra("woeid",-1);
        Log.d(TAG, "woeid Recieved" +woeidRecieved);
        if(woeidRecieved != -1){
            weatherAPI.getWeatherBywoeid(woeidRecieved).enqueue(WeatherCallBack);
            Log.d(TAG, "Woeid sent"+woeidRecieved);
       }
    }
}
