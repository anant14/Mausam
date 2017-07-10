package com.abc.mausam.Models;

import java.util.ArrayList;

/**
 * Created by anant bansal on 7/10/2017.
 */

public class Result {

    ArrayList<consolidated_weather>  weather;

    public Result(ArrayList<consolidated_weather> weather) {
        this.weather = weather;
    }

    public ArrayList<consolidated_weather> getWeather() {
        return weather;
    }
}
