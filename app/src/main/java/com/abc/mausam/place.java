package com.abc.mausam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.abc.mausam.API.LocationAPI;
import com.abc.mausam.Adapters.PlaceRecyclerAdapter;
import com.abc.mausam.Models.LocationSearch;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class place extends AppCompatActivity {

    public static final String TAG = "Place";


    RecyclerView rvplacelist;
    PlaceRecyclerAdapter placeRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        rvplacelist = (RecyclerView)findViewById(R.id.rvplacelist);
        rvplacelist.setLayoutManager(new LinearLayoutManager(this));
        placeRecyclerAdapter = new PlaceRecyclerAdapter(this , new ArrayList<LocationSearch>());
        rvplacelist.setAdapter(placeRecyclerAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.metaweather.com/api/")
                .addConverterFactory(
                        GsonConverterFactory.create()
                )
                .build();

        LocationAPI locationAPI = retrofit.create(LocationAPI.class);
        Callback<ArrayList<LocationSearch>> LocationCallback = new Callback<ArrayList<LocationSearch>>() {

            @Override
            public void onResponse(Call<ArrayList<LocationSearch>> call, Response<ArrayList<LocationSearch>> response) {
                placeRecyclerAdapter.updateLocation(response.body());
                Log.d(TAG, "Response Recieved" + response);
            }

            @Override
            public void onFailure(Call<ArrayList<LocationSearch>> call, Throwable t) {
                Log.d(TAG, "Response not recieved");

            }
        };



        String placeRecieved = getIntent().getStringExtra("place");
        Log.d(TAG, "onCreate: " + placeRecieved);
        locationAPI.getLocation(placeRecieved).enqueue(LocationCallback);
    }
}
