package com.abc.mausam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.abc.mausam.API.LocationAPI;
import com.abc.mausam.Adapters.PlaceRecyclerAdapter;
import com.abc.mausam.Models.LocationSearch;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlaceLocator extends AppCompatActivity {

    public static final String TAG = "PlaceLocator";

    EditText etplace;
    Button btnadd;
    RecyclerView rvplacelist;
    PlaceRecyclerAdapter placeRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placelocator);
        Log.d(TAG, "PlaceLocator Activity Started");


        btnadd = (Button)findViewById(R.id.btnadd);
        rvplacelist = (RecyclerView)findViewById(R.id.rvplacelist);
        rvplacelist.setLayoutManager(new LinearLayoutManager(this));
        placeRecyclerAdapter = new PlaceRecyclerAdapter(this , new ArrayList<LocationSearch>());
        rvplacelist.setAdapter(placeRecyclerAdapter);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etplace = (EditText)findViewById(R.id.etplace);
                String place = etplace.getText().toString();


                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.metaweather.com/api/")
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        )
                        .build();

                LocationAPI locationAPI = retrofit.create(LocationAPI.class);
                Log.d(TAG, "onClick: "+place);
              locationAPI.getLocation(place).enqueue(new Callback<ArrayList<LocationSearch>>() {
                  @Override
                  public void onResponse(Call<ArrayList<LocationSearch>> call, Response<ArrayList<LocationSearch>> response) {

                      Log.d(TAG, "onResponse: "+response.body());
                     placeRecyclerAdapter.updateLocation(response.body());
                  }

                  @Override
                  public void onFailure(Call<ArrayList<LocationSearch>> call, Throwable t) {
                      Log.d(TAG, "onFailure: "+t);
                  }
              });
            }
        });
    }
}
