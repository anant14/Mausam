package com.abc.mausam.API;

import com.abc.mausam.Models.Weather;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Nikhil Arora on 10-07-2017.
 */

public interface WeatherAPI {

    @GET("location/{woeid}/")
    Call<ArrayList<Weather>> getWeatherBywoeid (
            @Path("woeid") int woeid
    );
}
