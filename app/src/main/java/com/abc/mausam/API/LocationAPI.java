package com.abc.mausam.API;

import com.abc.mausam.Models.LocationSearch;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Nikhil Arora on 08-07-2017.
 */

public interface LocationAPI {

    @GET("location/search/")
    Call<ArrayList<LocationSearch>> getLocation(@Query("query") String place);
}
