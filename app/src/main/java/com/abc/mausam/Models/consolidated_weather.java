package com.abc.mausam.Models;

import java.util.Date;

/**
 * Created by Nikhil Arora on 10-07-2017.
 */

public class consolidated_weather {

    private int id;
    private Date applicable_date;
    private String weather_state_name;
    private String weather_state_abbr;
    private float wind_speed;
    private float wind_direction;
    private String wind_direction_compass;
    private float min_temp , max_temp , the_temp;
    private float air_pressure;
    private float humidity;
    private float visibility;
    private int predictability;

    public consolidated_weather(int id, Date applicable_date, String weather_state_name, String weather_state_abbr, float wind_speed, float wind_direction, String wind_direction_compass, float min_temp, float max_temp, float the_temp, float air_pressure, float humidity, float visibility, int predictability) {
        this.id = id;
        this.applicable_date = applicable_date;
        this.weather_state_name = weather_state_name;
        this.weather_state_abbr = weather_state_abbr;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
        this.wind_direction_compass = wind_direction_compass;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.the_temp = the_temp;
        this.air_pressure = air_pressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.predictability = predictability;
    }

    public int getId() {
        return id;
    }

    public Date getApplicable_date() {
        return applicable_date;
    }

    public String getWeather_state_name() {
        return weather_state_name;
    }

    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    public float getWind_speed() {
        return wind_speed;
    }

    public float getWind_direction() {
        return wind_direction;
    }

    public String getWind_direction_compass() {
        return wind_direction_compass;
    }

    public float getMin_temp() {
        return min_temp;
    }

    public float getMax_temp() {
        return max_temp;
    }

    public float getThe_temp() {
        return the_temp;
    }

    public float getAir_pressure() {
        return air_pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getVisibility() {
        return visibility;
    }

    public int getPredictability() {
        return predictability;
    }
}
