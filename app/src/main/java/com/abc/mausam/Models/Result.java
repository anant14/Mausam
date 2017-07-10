package com.abc.mausam.Models;

import java.util.ArrayList;

/**
 * Created by anant bansal on 7/10/2017.
 */

public class Result {

    ArrayList<consolidated_weather>  consolidated_weather;

    public Result(ArrayList<com.abc.mausam.Models.consolidated_weather> consolidated_weather) {
        this.consolidated_weather = consolidated_weather;
    }

    public ArrayList<com.abc.mausam.Models.consolidated_weather> getConsolidated_weather() {
        return consolidated_weather;
    }
}
